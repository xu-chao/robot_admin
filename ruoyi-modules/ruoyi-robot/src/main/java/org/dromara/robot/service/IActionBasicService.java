package org.dromara.robot.service;

import org.dromara.robot.domain.vo.ActionBasicVo;
import org.dromara.robot.domain.bo.ActionBasicBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 基础动作Service接口
 *
 * @author xuchao
 * @date 2026-02-03
 */
public interface IActionBasicService {

    /**
     * 查询基础动作
     *
     * @param id 主键
     * @return 基础动作
     */
    ActionBasicVo queryById(Long id);

    /**
     * 分页查询基础动作列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 基础动作分页列表
     */
    TableDataInfo<ActionBasicVo> queryPageList(ActionBasicBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的基础动作列表
     *
     * @param bo 查询条件
     * @return 基础动作列表
     */
    List<ActionBasicVo> queryList(ActionBasicBo bo);

    /**
     * 新增基础动作
     *
     * @param bo 基础动作
     * @return 是否新增成功
     */
    Boolean insertByBo(ActionBasicBo bo);

    /**
     * 修改基础动作
     *
     * @param bo 基础动作
     * @return 是否修改成功
     */
    Boolean updateByBo(ActionBasicBo bo);

    /**
     * 校验并批量删除基础动作信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
