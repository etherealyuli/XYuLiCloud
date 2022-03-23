package cn.xyuli.cloud.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName VerificationCodeLoginDto
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/14 6:08 PM
 * @Version 1.0
 **/
@Data
@ApiModel("验证码登录接口")
public class VerificationCodeLoginDto {
    @ApiModelProperty(value = "手机号码",required = true)
    @NotBlank(message = "手机号码不能为空")
    private String phone;
    @ApiModelProperty(value = "验证码",required = true)
    @NotBlank(message = "验证码不能为空")
    private String code;
}
