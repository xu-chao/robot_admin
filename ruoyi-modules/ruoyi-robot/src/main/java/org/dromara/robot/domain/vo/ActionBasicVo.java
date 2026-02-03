package org.dromara.robot.domain.vo;

import org.dromara.robot.domain.ActionBasic;
import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 基础动作视图对象 action_basic
 *
 * @author xuchao
 * @date 2026-02-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ActionBasic.class)
public class ActionBasicVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ExcelProperty(value = "主键ID")
    private Long id;

    /**
     * 部门id
     */
    @ExcelProperty(value = "部门id")
    private Long deptId;

    /**
     * 用户id
     */
    @ExcelProperty(value = "用户id")
    private Long userId;

    /**
     * 排序号
     */
    @ExcelProperty(value = "排序号")
    private Long orderNum;

    /**
     * 中文名称
     */
    @ExcelProperty(value = "中文名称")
    private String chineseName;

    /**
     * 英文名称
     */
    @ExcelProperty(value = "英文名称")
    private String englishName;

    /**
     * 图标路径
     */
    @ExcelProperty(value = "图标路径")
    private String icon;

    /**
     * API接口
     */
    @ExcelProperty(value = "API接口")
    private String api;

    /**
     * 动作类型
     */
    @ExcelProperty(value = "动作类型")
    private String type;

    /**
     * 执行时间(ms)
     */
    @ExcelProperty(value = "执行时间(ms)")
    private Long actionTime;

    /**
     * 所属模块
     */
    @ExcelProperty(value = "所属模块")
    private String module;

    /**
     * 执行命令
     */
    @ExcelProperty(value = "执行命令")
    private String command;

    /**
     * 适用环境(JSON数组)
     */
    @ExcelProperty(value = "适用环境(JSON数组)")
    private String env;

    /**
     * 是否禁用(0-启用,1-禁用)
     */
    @ExcelProperty(value = "是否禁用(0-启用,1-禁用)")
    private Long disable;

    /**
     * 输入参数(JSON数组)
     */
    @ExcelProperty(value = "输入参数(JSON数组)")
    private String inputs;


}
