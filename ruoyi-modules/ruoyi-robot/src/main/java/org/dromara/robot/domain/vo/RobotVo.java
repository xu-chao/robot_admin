package org.dromara.robot.domain.vo;

import org.dromara.robot.domain.Robot;
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
 * 机器人视图对象 robot
 *
 * @author xuchao
 * @date 2026-02-03
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = Robot.class)
public class RobotVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 机器人sn号
     */
    @ExcelProperty(value = "机器人sn号")
    private String sn;

    /**
     * 机器人名
     */
    @ExcelProperty(value = "机器人名")
    private String robotName;

    /**
     * 机器人类别：0-H1;1-GR3
     */
    @ExcelProperty(value = "机器人类别：0-H1;1-GR3")
    private Long robotType;

    /**
     * 机器人ip
     */
    @ExcelProperty(value = "机器人ip")
    private String robotIp;

    /**
     * 机器人用户名
     */
    @ExcelProperty(value = "机器人用户名")
    private String robotUserName;

    /**
     * 机器人用户密码
     */
    @ExcelProperty(value = "机器人用户密码")
    private String robotUserPassword;


}
