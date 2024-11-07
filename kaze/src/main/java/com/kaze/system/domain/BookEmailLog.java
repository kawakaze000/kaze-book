package com.kaze.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kaze.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 邮件日志对象 mt_email_log
 *
 * @author kaze
 * @date 2024-11-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("book_email_log")
public class BookEmailLog extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 类型
     */
    private String type;
    /**
     * 备注
     */
    private String notes;
    /**
     * 内容
     */
    private String content;

}
