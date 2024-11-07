package com.kaze.system.service;

import com.kaze.common.core.domain.R;
import com.kaze.system.domain.dto.ForgotPasswordDto;
import com.kaze.system.domain.dto.LoginDto;
import com.kaze.system.domain.dto.RegisterDto;
import com.kaze.system.domain.vo.LoginVo;

import java.util.Map;

/**
 * @author chen
 * @version V1.0
 * @since 2024/11/7 15:12
 */
public interface ILoginService {
    LoginVo register(RegisterDto dto);

    LoginVo login(LoginDto dto);

    void forgotPassword(ForgotPasswordDto dto);

    R emailCode(Map<String, String> map);
}
