package org.dromara.robot.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.dromara.robot.domain.bo.RobotBo;
import org.dromara.robot.domain.vo.RobotVo;
import org.dromara.robot.domain.Robot;
import org.dromara.robot.mapper.RobotMapper;
import org.dromara.robot.service.IRobotService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 机器人Service业务层处理
 *
 * @author xuchao
 * @date 2026-02-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class RobotServiceImpl implements IRobotService {

    private final RobotMapper baseMapper;

    /**
     * 查询机器人
     *
     * @param id 主键
     * @return 机器人
     */
    @Override
    public RobotVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询机器人列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 机器人分页列表
     */
    @Override
    public TableDataInfo<RobotVo> queryPageList(RobotBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Robot> lqw = buildQueryWrapper(bo);
        Page<RobotVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的机器人列表
     *
     * @param bo 查询条件
     * @return 机器人列表
     */
    @Override
    public List<RobotVo> queryList(RobotBo bo) {
        LambdaQueryWrapper<Robot> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<Robot> buildQueryWrapper(RobotBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Robot> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(Robot::getId);
        lqw.eq(StringUtils.isNotBlank(bo.getSn()), Robot::getSn, bo.getSn());
        lqw.like(StringUtils.isNotBlank(bo.getRobotName()), Robot::getRobotName, bo.getRobotName());
        lqw.eq(bo.getRobotType() != null, Robot::getRobotType, bo.getRobotType());
        lqw.eq(StringUtils.isNotBlank(bo.getRobotIp()), Robot::getRobotIp, bo.getRobotIp());
        lqw.like(StringUtils.isNotBlank(bo.getRobotUserName()), Robot::getRobotUserName, bo.getRobotUserName());
        lqw.eq(StringUtils.isNotBlank(bo.getRobotUserPassword()), Robot::getRobotUserPassword, bo.getRobotUserPassword());
        return lqw;
    }

    /**
     * 新增机器人
     *
     * @param bo 机器人
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(RobotBo bo) {
        Robot add = MapstructUtils.convert(bo, Robot.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改机器人
     *
     * @param bo 机器人
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(RobotBo bo) {
        Robot update = MapstructUtils.convert(bo, Robot.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(Robot entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除机器人信息
     *
     * @param ids     待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否删除成功
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteByIds(ids) > 0;
    }
}
