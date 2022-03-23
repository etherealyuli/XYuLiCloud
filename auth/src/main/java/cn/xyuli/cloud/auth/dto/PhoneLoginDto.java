package cn.xyuli.cloud.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName LoginDto
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/11 3:56 PM
 * @Version 1.0
 **/
@Data
@ApiModel("手机-密码登录")
public class PhoneLoginDto {
    @ApiModelProperty(value = "手机号码",required = true)
    @NotBlank(message = "用户名不能为空")
    private String phone;
    @ApiModelProperty(value = "密码",required = true)
    @NotBlank(message = "密码不能为空")
    private String pwd;
}
