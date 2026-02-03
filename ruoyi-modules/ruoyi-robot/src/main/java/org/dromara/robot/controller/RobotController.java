package org.dromara.robot.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.robot.domain.vo.RobotVo;
import org.dromara.robot.domain.bo.RobotBo;
import org.dromara.robot.service.IRobotService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 机器人
 *
 * @author xuchao
 * @date 2026-02-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/robot/robot")
public class RobotController extends BaseController {

    private final IRobotService robotService;

    /**
     * 查询机器人列表
     */
    @SaCheckPermission("robot:robot:list")
    @GetMapping("/list")
    public TableDataInfo<RobotVo> list(RobotBo bo, PageQuery pageQuery) {
        return robotService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出机器人列表
     */
    @SaCheckPermission("robot:robot:export")
    @Log(title = "机器人", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(RobotBo bo, HttpServletResponse response) {
        List<RobotVo> list = robotService.queryList(bo);
        ExcelUtil.exportExcel(list, "机器人", RobotVo.class, response);
    }

    /**
     * 获取机器人详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("robot:robot:query")
    @GetMapping("/{id}")
    public R<RobotVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(robotService.queryById(id));
    }

    /**
     * 新增机器人
     */
    @SaCheckPermission("robot:robot:add")
    @Log(title = "机器人", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody RobotBo bo) {
        return toAjax(robotService.insertByBo(bo));
    }

    /**
     * 修改机器人
     */
    @SaCheckPermission("robot:robot:edit")
    @Log(title = "机器人", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody RobotBo bo) {
        return toAjax(robotService.updateByBo(bo));
    }

    /**
     * 删除机器人
     *
     * @param ids 主键串
     */
    @SaCheckPermission("robot:robot:remove")
    @Log(title = "机器人", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(robotService.deleteWithValidByIds(List.of(ids), true));
    }
}
