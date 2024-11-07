package com.kaze.system.domain.vo;

import com.kaze.system.domain.BookUser;
import lombok.Data;

/**
 * @author chen
 * @version V1.0
 * @since 2024/11/7 15:14
 */
@Data
public class LoginVo {

    private BookUser user;

    private String token;

}
