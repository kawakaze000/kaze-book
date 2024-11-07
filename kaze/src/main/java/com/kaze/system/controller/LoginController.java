package com.kaze.system.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.kaze.common.core.domain.R;
import com.kaze.system.domain.dto.ForgotPasswordDto;
import com.kaze.system.domain.dto.LoginDto;
import com.kaze.system.domain.dto.RegisterDto;
import com.kaze.system.domain.vo.LoginVo;
import com.kaze.system.service.ILoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author chen
 * @version V1.0
 * @since 2024/11/7 15:09
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/login")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    /**
     * 注册
     */
    @PostMapping("/register")
    @SaIgnore
    public R<LoginVo> register(@RequestBody @Validated RegisterDto dto) {
        return R.ok(loginService.register(dto));
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    @SaIgnore
    public R<LoginVo> login(@RequestBody @Validated LoginDto dto) {
        return R.ok(loginService.login(dto));
    }

    /**
     * 忘记密码
     */
    @PostMapping("/forgotPassword")
    @SaIgnore
    public R<Void> forgotPassword(@RequestBody @Validated ForgotPasswordDto dto) {
        loginService.forgotPassword(dto);
        return R.ok();
    }



    /**
     * 邮箱验证码
     */
    @PostMapping("/captchaEmail")
    @SaIgnore
    public R<Void> emailCode(@RequestBody Map<String, String> map) {
        return loginService.emailCode(map);
    }

}
