package com.kaze.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.kaze.common.annotation.ExcelDictFormat;
import com.kaze.common.convert.ExcelDictConvert;
import lombok.Data;


/**
 * 等级管理视图对象 book_level
 *
 * @author kaze
 * @date 2024-11-07
 */
@Data
@ExcelIgnoreUnannotated
public class BookLevelVo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 等级
     */
    @ExcelProperty(value = "等级")
    private Integer level;

    /**
     * 等级名称
     */
    @ExcelProperty(value = "等级名称")
    private String levelName;

    /**
     * 经验值
     */
    @ExcelProperty(value = "经验值")
    private Integer exp;


}
