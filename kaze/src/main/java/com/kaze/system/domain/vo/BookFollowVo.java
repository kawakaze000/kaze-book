package com.kaze.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.kaze.common.annotation.ExcelDictFormat;
import com.kaze.common.convert.ExcelDictConvert;
import lombok.Data;


/**
 * 【请填写功能名称】视图对象 book_follow
 *
 * @author ruoyi
 * @date 2024-11-07
 */
@Data
@ExcelIgnoreUnannotated
public class BookFollowVo {

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
     * 关注者id
     */
    @ExcelProperty(value = "关注者id")
    private Long followId;

    /**
     * 粉丝id
     */
    @ExcelProperty(value = "粉丝id")
    private Long fanId;

    /**
     * 用户名
     */
    @ExcelProperty(value = "用户名")
    private String userName;

    /**
     * 用户头像
     */
    @ExcelProperty(value = "用户头像")
    private String userImg;


}
