package com.kaze.system.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.kaze.common.constant.CacheConstants;
import com.kaze.common.constant.Constants;
import com.kaze.common.core.domain.R;
import com.kaze.common.core.domain.event.LogininforEvent;
import com.kaze.common.exception.ServiceException;
import com.kaze.common.exception.user.CaptchaExpireException;
import com.kaze.common.utils.MessageUtils;
import com.kaze.common.utils.ServletUtils;
import com.kaze.common.utils.StringUtils;
import com.kaze.common.utils.email.MailUtils;
import com.kaze.common.utils.redis.RedisUtils;
import com.kaze.common.utils.spring.SpringUtils;
import com.kaze.system.domain.BookEmailLog;
import com.kaze.system.domain.dto.ForgotPasswordDto;
import com.kaze.system.domain.dto.LoginDto;
import com.kaze.system.domain.dto.RegisterDto;
import com.kaze.system.domain.vo.LoginVo;
import com.kaze.system.mapper.BookEmailLogMapper;
import com.kaze.system.mapper.BookUserMapper;
import com.kaze.system.service.ILoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.Map;

import static com.kaze.system.constant.EmailType.EMAIL_CODE;

/**
 * @author chen
 * @version V1.0
 * @since 2024/11/7 15:12
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements ILoginService {

    private final BookUserMapper userMapper;

    @Override
    public LoginVo register(RegisterDto dto) {
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            throw new ServiceException("两次密码不一致");
        }
        return null;
    }

    @Override
    public LoginVo login(LoginDto dto) {
        return null;
    }

    @Override
    public void forgotPassword(ForgotPasswordDto dto) {

    }

    @Override
    public R emailCode(Map<String, String> map) {
//        if (!isProd) return R.ok();
        String email = map.get("email");
        String uuid = map.get("uuid");
        String imgCode = map.get("imgCode");
        if (StringUtils.isBlank(email)) {
            return R.fail(MessageUtils.message("user.email.not.blank"));
        }
        if (StringUtils.isBlank(uuid)) {
            return R.fail(MessageUtils.message("code.id.not.null"));
        }
        if (StringUtils.isBlank(imgCode)) {
            return R.fail(MessageUtils.message("user.image.code.not.null"));
        }

        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + uuid;
        if (!RedisUtils.isExistsObject(verifyKey)) {
            return R.fail(MessageUtils.message("user.captcha.expire"));
        }

        String verifyCode = RedisUtils.getCacheObject(verifyKey);
        if (!verifyCode.equals(imgCode)) {
            return R.fail(MessageUtils.message("user.captcha.error"));
        }

//        if (!mailProperties.getEnabled()) {
//            return R.fail("当前系统没有开启邮箱功能！");
//        }
        String key = CacheConstants.CAPTCHA_CODE_KEY + email;
        String code = RandomUtil.randomNumbers(4);
        RedisUtils.setCacheObject(key, code, Duration.ofMinutes(Constants.CAPTCHA_EXPIRATION));
        try {
            String content = "您本次验证码为：" + code + "，有效性为" + Constants.CAPTCHA_EXPIRATION + "分钟，请尽快填写。";
            MailUtils.sendText(email, "登录验证码", content);

            BookEmailLogMapper emailLogMapper = SpringUtils.getBean(BookEmailLogMapper.class);
            BookEmailLog emailLog = new BookEmailLog();
            emailLog.setEmail(email);
            emailLog.setType(EMAIL_CODE);
            emailLog.setContent(content);
            emailLog.setCreateTime(new Date());
            emailLogMapper.insert(emailLog);

        } catch (Exception e) {
            log.error("验证码发送异常 => {}", e.getMessage());
            return R.fail(e.getMessage());
        }
        return R.ok();
    }

    /**
     * 记录登录信息
     *
     * @param username 用户名
     * @param status   状态
     * @param message  消息内容
     */
    private void recordLogininfor(String username, String status, String message) {
        LogininforEvent logininforEvent = new LogininforEvent();
        logininforEvent.setUsername(username);
        logininforEvent.setStatus(status);
        logininforEvent.setMessage(message);
        logininforEvent.setRequest(ServletUtils.getRequest());
        SpringUtils.context().publishEvent(logininforEvent);
    }

    /**
     * 校验邮箱验证码
     */
    private boolean validateEmailCode(String email, String emailCode) {
        String code = RedisUtils.getCacheObject(CacheConstants.CAPTCHA_CODE_KEY + email);
        if (StringUtils.isBlank(code)) {
            recordLogininfor(email, Constants.LOGIN_FAIL, MessageUtils.message("验证码已失效"));
            throw new CaptchaExpireException();
        }
        return code.equals(emailCode);
    }

}
