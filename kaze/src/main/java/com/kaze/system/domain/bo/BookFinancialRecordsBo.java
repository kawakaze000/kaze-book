package com.kaze.system.domain.bo;

import com.kaze.common.core.domain.BaseEntity;
import com.kaze.common.core.validate.AddGroup;
import com.kaze.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.math.BigDecimal;

/**
 * 账户明细业务对象 book_financial_records
 *
 * @author kaze
 * @date 2024-11-07
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class BookFinancialRecordsBo extends BaseEntity {

    /**
     * 
     */
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long userId;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String userName;

    /**
     * 收支类型(0: 收入、1:支出)
     */
    @NotNull(message = "收支类型(0: 收入、1:支出)不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long type;

    /**
     * 类型(0: 后台赠送、1: 抽奖获得、2: 余额支付、3: 支付宝支付)
     */
    @NotNull(message = "类型(0: 后台赠送、1: 抽奖获得、2: 余额支付、3: 支付宝支付)不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer payType;

    /**
     * 记录内容
     */
    @NotBlank(message = "记录内容不能为空", groups = { AddGroup.class, EditGroup.class })
    private String content;

    /**
     * 金额
     */
    @NotNull(message = "金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal amount;

    /**
     * 备注
     */
    @NotBlank(message = "备注不能为空", groups = { AddGroup.class, EditGroup.class })
    private String notes;


}
