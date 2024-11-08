package com.kaze.system.enums;

/**
 * @author chen
 * @version V1.0
 * @since 2024/11/7 15:22
 */
public enum ErrorCode {
    USER_NOT_EXIST(10001, "用户不存在"),
    USER_PASSWORD_ERROR(10002, "用户名或密码错误"),
    USER_NOT_LOGIN(10003, "用户未登录"),
    USER_NOT_AUTHORIZED(10004, "用户未授权"),
    USER_NOT_ENABLE(10005, "用户未启用"),
    USER_NOT_EXPIRE(10006, "用户未过期"),
    USER_NOT_LOCK(10007, "用户未锁定"),

    ARTICLE_NOT_EXIST(20001,"文章不存在"),
    ARTICLE_ID_NOT_NULL(20002,"文章id不能为空"),

    EMAIL_REPEAT_SEND(30001,"请求太频繁，稍后再试"),
    ;

    private final Integer code;

    private final String msg;

    ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
