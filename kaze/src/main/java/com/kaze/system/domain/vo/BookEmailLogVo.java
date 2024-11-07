package com.kaze.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 邮件日志视图对象 mt_email_log
 *
 * @author ruoyi
 * @date 2024-11-07
 */
@Data
@ExcelIgnoreUnannotated
public class BookEmailLogVo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 邮箱
     */
    @ExcelProperty(value = "邮箱")
    private String email;

    /**
     * 类型
     */
    @ExcelProperty(value = "类型")
    private String type;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String notes;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 内容
     */
    @ExcelProperty(value = "内容")
    private String content;


}
