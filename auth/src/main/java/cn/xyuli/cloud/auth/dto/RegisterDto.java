package cn.xyuli.cloud.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName RegisterDto
 * @Description TODO
 * @Author xyuli
 * @Date 2022/3/11 3:58 PM
 * @Version 1.0
 **/
@Data
@ApiModel("注册")
public class RegisterDto {
    @ApiModelProperty(value = "用户名",required = true)
    @NotBlank(message = "用户名不能为空")
    private String name;
    @ApiModelProperty(value = "密码",required = true)
    @NotBlank(message = "密码不能为空")
    private String pwd;
}
