package org.dromara.robot.domain.bo;

import org.dromara.robot.domain.ActionBasic;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 基础动作业务对象 action_basic
 *
 * @author xuchao
 * @date 2026-02-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = ActionBasic.class, reverseConvertGenerate = false)
public class ActionBasicBo extends BaseEntity {

    /**
     * 主键ID
     */
    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
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


}
