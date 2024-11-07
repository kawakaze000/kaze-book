package com.kaze.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.kaze.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 账户明细对象 book_financial_records
 *
 * @author kaze
 * @date 2024-11-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("book_financial_records")
public class BookFinancialRecords extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 收支类型(0: 收入、1:支出)
     */
    private Long type;
    /**
     * 类型(0: 后台赠送、1: 抽奖获得、2: 余额支付、3: 支付宝支付)
     */
    private Integer payType;
    /**
     * 记录内容
     */
    private String content;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 备注
     */
    private String notes;

}
