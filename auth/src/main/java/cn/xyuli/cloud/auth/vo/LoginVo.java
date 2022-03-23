package cn.xyuli.cloud.auth.vo;

import cn.xyuli.cloud.common.entity.Token;
import cn.xyuli.cloud.common.entity.User;
import cn.xyuli.cloud.common.enums.UserStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @ClassName LoginVo
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/14 6:14 PM
 * @Version 1.0
 **/
@Data
@ApiModel("登录成功返回信息")
@NoArgsConstructor
public class LoginVo{
    @ApiModelProperty(value = "用户ID")
    private String userId;
    @ApiModelProperty(value = "公共ID")
    private String openId;
    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "状态")
    private UserStatus status;
    @ApiModelProperty(value = "状态")
    private String token;
    @ApiModelProperty(value = "token过期时间")
    private Date tokenExpiredDate;

    public LoginVo(Token token){
        this.userId = token.getUserId();
        this.openId = token.getOpenId();
        this.name = token.getName();
        this.phone = token.getPhone();
        this.status = token.getStatus();
        this.token = token.getToken();
        this.tokenExpiredDate = token.getTokenExpiredDate();
    }
}
