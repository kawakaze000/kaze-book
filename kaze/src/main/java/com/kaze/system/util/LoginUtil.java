package com.kaze.system.util;

import com.kaze.common.utils.StpUserUtil;
import com.kaze.common.utils.spring.SpringUtils;
import com.kaze.system.domain.BookUser;
import com.kaze.system.mapper.BookUserMapper;

public class LoginUtil {

    public static Long getUserId(){
        return StpUserUtil.getLoginIdAsLong();
    }

    public static BookUser getUser(){
        BookUserMapper userMapper = SpringUtils.getBean(BookUserMapper.class);
        return userMapper.selectById(StpUserUtil.getLoginIdAsLong());
    }

}
