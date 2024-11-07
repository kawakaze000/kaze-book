package com.kaze.system.domain.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.kaze.common.annotation.ExcelDictFormat;
import com.kaze.common.convert.ExcelDictConvert;
import lombok.Data;


/**
 * 用户管理视图对象 book_user
 *
 * @author kaze
 * @date 2024-11-07
 */
@Data
@ExcelIgnoreUnannotated
public class BookUserVo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 昵称
     */
    @ExcelProperty(value = "昵称")
    private String name;

    /**
     * 邮箱
     */
    @ExcelProperty(value = "邮箱")
    private String email;

    /**
     * 密码
     */
    @ExcelProperty(value = "密码")
    private String password;

    /**
     * 头像
     */
    @ExcelProperty(value = "头像")
    private String img;

    /**
     * 勋章
     */
    @ExcelProperty(value = "勋章")
    private Integer medal;

    /**
     * 等级
     */
    @ExcelProperty(value = "等级")
    private Integer level;

    /**
     * 经验值
     */
    @ExcelProperty(value = "经验值")
    private Integer exp;

    /**
     * vip
     */
    @ExcelProperty(value = "vip")
    private Date vip;

    /**
     * 认证
     */
    @ExcelProperty(value = "认证")
    private String authentication;

    /**
     * 关注数
     */
    @ExcelProperty(value = "关注数")
    private Integer follow;

    /**
     * 粉丝数
     */
    @ExcelProperty(value = "粉丝数")
    private Integer fans;

    /**
     * 文章数
     */
    @ExcelProperty(value = "文章数")
    private Integer article;

    /**
     * 
     */
    @ExcelProperty(value = "")
    private Date createTime;


}
