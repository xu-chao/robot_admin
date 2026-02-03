package org.dromara.robot.domain.bo;

import org.dromara.robot.domain.Robot;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 机器人业务对象 robot
 *
 * @author xuchao
 * @date 2026-02-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Robot.class, reverseConvertGenerate = false)
public class RobotBo extends BaseEntity {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 机器人sn号
     */
    private String sn;

    /**
     * 机器人名
     */
    private String robotName;

    /**
     * 机器人类别：0-H1;1-GR3
     */
    private Long robotType;

    /**
     * 机器人ip
     */
    private String robotIp;

    /**
     * 机器人用户名
     */
    private String robotUserName;

    /**
     * 机器人用户密码
     */
    private String robotUserPassword;


}
