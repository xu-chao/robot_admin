package org.dromara.robot.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 机器人对象 robot
 *
 * @author xuchao
 * @date 2026-02-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("robot")
public class Robot extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id")
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
     * 版本
     */
    @Version
    private String version;

    /**
     * 机器人用户名
     */
    private String robotUserName;

    /**
     * 机器人用户密码
     */
    private String robotUserPassword;

    /**
     * 删除标志
     */
    @TableLogic
    private Long delFlag;


}
