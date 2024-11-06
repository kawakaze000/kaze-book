package com.kaze.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @author chen
 * @version V1.0
 * @since 2023/3/4 14:33
 */
public class RegisterUtils {
    /**
     * md5加密
     */
    public static String encrypByMd5(String context) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //update处理
            md.update(context.getBytes());
            //调用该方法完成计算
            byte [] encryContext = md.digest();

            int i;
            StringBuilder buf = new StringBuilder();
            //做相应的转化（十六进制）
            for (int offset = 0; offset < encryContext.length; offset++) {
                i = encryContext[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成盐
     */
    public static String getSalt() {
        String str = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int number = random.nextInt(10);
            sb.append(str.charAt(number));
        }
        return sb.toString();

    }
}
