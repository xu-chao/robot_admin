package org.dromara.robot.service;

import org.dromara.robot.domain.vo.RobotVo;
import org.dromara.robot.domain.bo.RobotBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 机器人Service接口
 *
 * @author xuchao
 * @date 2026-02-03
 */
public interface IRobotService {

    /**
     * 查询机器人
     *
     * @param id 主键
     * @return 机器人
     */
    RobotVo queryById(Long id);

    /**
     * 分页查询机器人列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 机器人分页列表
     */
    TableDataInfo<RobotVo> queryPageList(RobotBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的机器人列表
     *
     * @param bo 查询条件
     * @return 机器人列表
     */
    List<RobotVo> queryList(RobotBo bo);

    /**
     * 新增机器人
     *
     * @param bo 机器人
     * @return 是否新增成功
     */
    Boolean insertByBo(RobotBo bo);

    /**
     * 修改机器人
     *
     * @param bo 机器人
     * @return 是否修改成功
     */
    Boolean updateByBo(RobotBo bo);

    /**
     * 校验并批量删除机器人信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
