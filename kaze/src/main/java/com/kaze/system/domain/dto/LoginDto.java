package com.kaze.system.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author chen
 * @version V1.0
 * @since 2024/11/7 15:13
 */
@Data
public class LoginDto {

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
     * uuid
     */
//    @NotBlank(message = "code.id.not.null")
    private String uuid;

    /**
     * 验证码
     */
//    @NotBlank(message = "user.image.code.not.null")
    private String code;

}
