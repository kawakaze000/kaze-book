package com.kaze.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author chen
 * @version V1.0
 * @since 2024/11/7 15:13
 */
@Data
public class ForgotPasswordDto {

    /**
     * 邮箱
     */
    @NotBlank(message = "user.email.not.blank")
    private String email;

    /**
     * 密码
     */
    @NotBlank(message = "user.password.not.blank")
    private String password;

    /**
     * 确认密码
     */
    @NotBlank(message = "user.confirm.password.not.blank")
    private String confirmPassword;

    /**
     * 验证码
     */
    @NotBlank(message = "user.email.code.not.null")
    private String code;

}
