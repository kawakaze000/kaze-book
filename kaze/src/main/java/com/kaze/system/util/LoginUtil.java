package com.kaze.system.util;

import com.kaze.common.utils.StpUserUtil;
import com.kaze.common.utils.spring.SpringUtils;
//import com.kaze.system.domain.MtIndexUser;
//import com.kaze.system.mapper.MtIndexUserMapper;

public class LoginUtil {

    public static Long getUserId(){
        return StpUserUtil.getLoginIdAsLong();
    }

//    public static MtIndexUser getUser(){
//        MtIndexUserMapper indexUserMapper = SpringUtils.getBean(MtIndexUserMapper.class);
//        return indexUserMapper.selectById(StpUserUtil.getLoginIdAsLong());
//    }

}
