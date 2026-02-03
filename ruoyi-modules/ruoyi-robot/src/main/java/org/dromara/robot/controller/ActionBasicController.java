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
import org.dromara.robot.domain.vo.ActionBasicVo;
import org.dromara.robot.domain.bo.ActionBasicBo;
import org.dromara.robot.service.IActionBasicService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 基础动作
 *
 * @author xuchao
 * @date 2026-02-03
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/action/action")
public class ActionBasicController extends BaseController {

    private final IActionBasicService actionBasicService;

    /**
     * 查询基础动作列表
     */
    @SaCheckPermission("action:action:list")
    @GetMapping("/list")
    public TableDataInfo<ActionBasicVo> list(ActionBasicBo bo, PageQuery pageQuery) {
        return actionBasicService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出基础动作列表
     */
    @SaCheckPermission("action:action:export")
    @Log(title = "基础动作", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(ActionBasicBo bo, HttpServletResponse response) {
        List<ActionBasicVo> list = actionBasicService.queryList(bo);
        ExcelUtil.exportExcel(list, "基础动作", ActionBasicVo.class, response);
    }

    /**
     * 获取基础动作详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("action:action:query")
    @GetMapping("/{id}")
    public R<ActionBasicVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(actionBasicService.queryById(id));
    }

    /**
     * 新增基础动作
     */
    @SaCheckPermission("action:action:add")
    @Log(title = "基础动作", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody ActionBasicBo bo) {
        return toAjax(actionBasicService.insertByBo(bo));
    }

    /**
     * 修改基础动作
     */
    @SaCheckPermission("action:action:edit")
    @Log(title = "基础动作", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody ActionBasicBo bo) {
        return toAjax(actionBasicService.updateByBo(bo));
    }

    /**
     * 删除基础动作
     *
     * @param ids 主键串
     */
    @SaCheckPermission("action:action:remove")
    @Log(title = "基础动作", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(actionBasicService.deleteWithValidByIds(List.of(ids), true));
    }
}
