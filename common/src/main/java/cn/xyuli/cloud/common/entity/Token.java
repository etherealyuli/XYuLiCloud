package cn.xyuli.cloud.common.entity;

import cn.xyuli.cloud.common.enums.UserStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName LoginVo
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/14 6:14 PM
 * @Version 1.0
 **/
@Data
public class Token implements Serializable {
    private String userId;
    private String openId;
    private String name;
    private String phone;
    private UserStatus status;
    private String token;
    private Date tokenExpiredDate;
}
