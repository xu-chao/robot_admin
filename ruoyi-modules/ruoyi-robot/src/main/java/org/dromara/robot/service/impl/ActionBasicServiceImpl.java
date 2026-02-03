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
import org.dromara.robot.domain.bo.ActionBasicBo;
import org.dromara.robot.domain.vo.ActionBasicVo;
import org.dromara.robot.domain.ActionBasic;
import org.dromara.robot.mapper.ActionBasicMapper;
import org.dromara.robot.service.IActionBasicService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 基础动作Service业务层处理
 *
 * @author xuchao
 * @date 2026-02-03
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ActionBasicServiceImpl implements IActionBasicService {

    private final ActionBasicMapper baseMapper;

    /**
     * 查询基础动作
     *
     * @param id 主键
     * @return 基础动作
     */
    @Override
    public ActionBasicVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 分页查询基础动作列表
     *
     * @param bo        查询条件
     * @param pageQuery 分页参数
     * @return 基础动作分页列表
     */
    @Override
    public TableDataInfo<ActionBasicVo> queryPageList(ActionBasicBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<ActionBasic> lqw = buildQueryWrapper(bo);
        Page<ActionBasicVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询符合条件的基础动作列表
     *
     * @param bo 查询条件
     * @return 基础动作列表
     */
    @Override
    public List<ActionBasicVo> queryList(ActionBasicBo bo) {
        LambdaQueryWrapper<ActionBasic> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<ActionBasic> buildQueryWrapper(ActionBasicBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<ActionBasic> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(ActionBasic::getId);
        lqw.eq(bo.getDeptId() != null, ActionBasic::getDeptId, bo.getDeptId());
        lqw.eq(bo.getUserId() != null, ActionBasic::getUserId, bo.getUserId());
        lqw.eq(bo.getOrderNum() != null, ActionBasic::getOrderNum, bo.getOrderNum());
        lqw.like(StringUtils.isNotBlank(bo.getChineseName()), ActionBasic::getChineseName, bo.getChineseName());
        lqw.like(StringUtils.isNotBlank(bo.getEnglishName()), ActionBasic::getEnglishName, bo.getEnglishName());
        lqw.eq(StringUtils.isNotBlank(bo.getIcon()), ActionBasic::getIcon, bo.getIcon());
        lqw.eq(StringUtils.isNotBlank(bo.getApi()), ActionBasic::getApi, bo.getApi());
        lqw.eq(StringUtils.isNotBlank(bo.getType()), ActionBasic::getType, bo.getType());
        lqw.eq(bo.getActionTime() != null, ActionBasic::getActionTime, bo.getActionTime());
        lqw.eq(StringUtils.isNotBlank(bo.getModule()), ActionBasic::getModule, bo.getModule());
        lqw.eq(StringUtils.isNotBlank(bo.getCommand()), ActionBasic::getCommand, bo.getCommand());
        lqw.eq(StringUtils.isNotBlank(bo.getEnv()), ActionBasic::getEnv, bo.getEnv());
        lqw.eq(bo.getDisable() != null, ActionBasic::getDisable, bo.getDisable());
        lqw.eq(StringUtils.isNotBlank(bo.getInputs()), ActionBasic::getInputs, bo.getInputs());
        return lqw;
    }

    /**
     * 新增基础动作
     *
     * @param bo 基础动作
     * @return 是否新增成功
     */
    @Override
    public Boolean insertByBo(ActionBasicBo bo) {
        ActionBasic add = MapstructUtils.convert(bo, ActionBasic.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改基础动作
     *
     * @param bo 基础动作
     * @return 是否修改成功
     */
    @Override
    public Boolean updateByBo(ActionBasicBo bo) {
        ActionBasic update = MapstructUtils.convert(bo, ActionBasic.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(ActionBasic entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 校验并批量删除基础动作信息
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
