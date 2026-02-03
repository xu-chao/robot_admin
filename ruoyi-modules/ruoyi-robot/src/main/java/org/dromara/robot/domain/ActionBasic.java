package org.dromara.robot.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 基础动作对象 action_basic
 *
 * @author xuchao
 * @date 2026-02-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("action_basic")
public class ActionBasic extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 部门id
     */
    private Long deptId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 排序号
     */
    private Long orderNum;

    /**
     * 中文名称
     */
    private String chineseName;

    /**
     * 英文名称
     */
    private String englishName;

    /**
     * 图标路径
     */
    private String icon;

    /**
     * API接口
     */
    private String api;

    /**
     * 动作类型
     */
    private String type;

    /**
     * 执行时间(ms)
     */
    private Long actionTime;

    /**
     * 所属模块
     */
    private String module;

    /**
     * 执行命令
     */
    private String command;

    /**
     * 适用环境(JSON数组)
     */
    private String env;

    /**
     * 是否禁用(0-启用,1-禁用)
     */
    private Long disable;

    /**
     * 输入参数(JSON数组)
     */
    private String inputs;

    /**
     * 删除标志(0-正常,1-删除)
     */
    @TableLogic
    private Long delFlag;


}
