package cn.xyuli.cloud.common.entity;

import cn.xyuli.cloud.common.enums.UserStatus;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/11 4:51 PM
 * @Version 1.0
 **/
@Data
public class User {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 公共ID
     */
    private String openId;
    /**
     * 用户名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 状态
     */
    private UserStatus status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标识
     */
    private Boolean del;
}
