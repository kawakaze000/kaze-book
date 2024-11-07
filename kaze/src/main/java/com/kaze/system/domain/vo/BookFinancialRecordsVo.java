package com.kaze.system.domain.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.kaze.common.annotation.ExcelDictFormat;
import com.kaze.common.convert.ExcelDictConvert;
import lombok.Data;


/**
 * 账户明细视图对象 book_financial_records
 *
 * @author kaze
 * @date 2024-11-07
 */
@Data
@ExcelIgnoreUnannotated
public class BookFinancialRecordsVo {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 用户id
     */
    @ExcelProperty(value = "用户id")
    private Long userId;

    /**
     * 用户名
     */
    @ExcelProperty(value = "用户名")
    private String userName;

    /**
     * 收支类型(0: 收入、1:支出)
     */
    @ExcelProperty(value = "收支类型(0: 收入、1:支出)")
    private Long type;

    /**
     * 类型(0: 后台赠送、1: 抽奖获得、2: 余额支付、3: 支付宝支付)
     */
    @ExcelProperty(value = "类型(0: 后台赠送、1: 抽奖获得、2: 余额支付、3: 支付宝支付)")
    private Integer payType;

    /**
     * 记录内容
     */
    @ExcelProperty(value = "记录内容")
    private String content;

    /**
     * 金额
     */
    @ExcelProperty(value = "金额")
    private BigDecimal amount;

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


}
