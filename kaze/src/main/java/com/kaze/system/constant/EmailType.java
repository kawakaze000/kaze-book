package com.kaze.system.constant;

/**
 * @author chen
 * @version V1.0
 * @since 2024/8/24 16:30
 */
public interface EmailType {

    /**
     * 验证码
     */
    String EMAIL_CODE = "验证码邮件";

    /**
     * 注册成功
     */
    String EMAIL_REGISTER_SUCCESS = "注册成功邮件";

    /**
     * 管理员上下分
     */
    String EMAIL_ADJUSTING_ASSETS = "管理员上下分邮件";

    /**
     * 充值成功
     */
    String EMAIL_RECHARGE_SUCCESS = "充值成功邮件";

    /**
     * 充值失败
     */
    String EMAIL_RECHARGE_FAIL = "充值失败邮件";

    /**
     * 银行卡提现成功
     */
    String EMAIL_CASH_BANK_SUCCESS = "银行卡提现成功邮件";

    /**
     * 银行卡提现失败
     */
    String EMAIL_CASH_BANK_FAIL = "银行卡提现失败邮件";

    /**
     * 数字货币地址提现成功
     */
    String EMAIL_CASH_ADDRESS_SUCCESS = "数字货币地址提现成功邮件";

    /**
     * 数字货币地址提现失败
     */
    String EMAIL_CASH_ADDRESS_FAIL = "数字货币地址提现失败邮件";

    /**
     * 实名成功
     */
    String EMAIL_IDENTITY_SUCCESS = "实名成功邮件";

    /**
     * 实名失败
     */
    String EMAIL_IDENTITY_FAIL = "实名失败邮件";

}
