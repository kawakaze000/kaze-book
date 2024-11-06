package com.kaze.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class LangUtil {

    public static String getLang(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String header;
        if (Objects.nonNull(servletRequestAttributes)){
            HttpServletRequest request = servletRequestAttributes.getRequest();
            header = request.getHeader("content-language");
        }else {
            header = "en_US";
        }
        if (StringUtils.isBlank(header)){
            header = "en_US";
        }
        String[] split = header.split("_");
        String str;
        switch (split[0]) {
            case "zh":
                str = "zh_cn";
                break;
            case "vi":
                str = "vi";
                break;
            case "tw":
                str = "zh_tw";
                break;
            case "nl":
                str = "nl";
                break;
            case "fr":
                str = "fr";
                break;
            case "de":
                str = "de";
                break;
            case "hi":
                str = "hi";
                break;
            case "ides":
                str = "ides";
                break;
            case "ja":
                str = "ja";
                break;
            case "ko":
                str = "ko";
                break;
            case "pt":
                str = "pt";
                break;
            case "ru":
                str = "ru";
                break;
            case "es":
                str = "es";
                break;
            case "th":
                str = "th";
                break;
            case "tr":
                str = "tr";
                break;
            default:
                str = "en";
        }
        return str;
    }

}
