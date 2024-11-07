package com.kaze.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author chen
 * @version V1.0
 * @since 2024/11/7 15:13
 */
@Data
public class RegisterDto {

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    private String email;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 确认密码
     */
    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;

    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空")
    private String code;

}
