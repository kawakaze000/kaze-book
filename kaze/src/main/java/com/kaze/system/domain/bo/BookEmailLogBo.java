package com.kaze.system.domain.bo;

import com.kaze.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 邮件日志业务对象 mt_email_log
 *
 * @author kaze
 * @date 2024-11-07
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class BookEmailLogBo extends BaseEntity {

    /**
     * id
     */
    private Long id;

    /**
     * 邮箱
     */
    private String email;


}
