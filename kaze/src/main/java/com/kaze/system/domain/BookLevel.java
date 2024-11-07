package com.kaze.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.kaze.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 等级管理对象 book_level
 *
 * @author kaze
 * @date 2024-11-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("book_level")
public class BookLevel extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 等级
     */
    private Integer level;
    /**
     * 等级名称
     */
    private String levelName;
    /**
     * 经验值
     */
    private Integer exp;

}
