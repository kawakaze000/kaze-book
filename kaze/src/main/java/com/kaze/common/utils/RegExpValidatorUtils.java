package com.kaze.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chen
 * @version V1.0
 * @since 2023/3/4 14:07
 */
public class RegExpValidatorUtils {

    /**
     * 验证Email地址
     *
     * @param str 待验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean checkEmail(String str) {
        String regex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        return match(regex, str);
    }

    /**
     * 验证域名
     *
     * @param str 待验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean checkRealmName(String str) {
        String regex = "[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(/.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+/.?";
        return match(regex, str);
    }

    /**
     * 验证InternetURL
     *
     * @param str 待验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean checkInternetUrl(String str) {
        String regex = "[a-zA-z]+://[^\\s]* 或 ^http://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";
        return match(regex, str);
    }

    /**
     * 验证手机号码
     *
     * @param str 待验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean checkPhone(String str) {
        String regex = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
        return match(regex, str);
    }

    /**
     * 验证输入密码(以字母开头，长度在6~18之间，只能包含字母、数字和下划线)
     *
     * @param str 待验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean checkPassword(String str) {
        String regex = "^[a-zA-Z]\\w{5,17}$";
        return match(regex, str);
    }

    /**
     * 验证资金密码(6-18个字符，至少一个字母和一个数字)
     *
     * @param str 待验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean checkPayPassword(String str) {
        String regex = "\"^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,18}$\"";
        return match(regex, str);
    }

    /**
     * 验证用户名
     *
     * @param str 待验证的字符串
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean checkUsername(String str) {
        String regex = "^[a-zA-Z]\\w{1,19}$";
        return match(regex, str);
    }

    /**
     * @param regex
     * 正则表达式字符串
     * @param str
     * 要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
     */
    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
