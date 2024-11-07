package com.kaze.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.kaze.common.annotation.ExcelDictFormat;
import com.kaze.common.convert.ExcelDictConvert;
import lombok.Data;

import java.util.Date;


/**
 * 评论管理视图对象 book_comment
 *
 * @author kaze
 * @date 2024-11-07
 */
@Data
@ExcelIgnoreUnannotated
public class BookCommentVo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
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
     * 用户头像
     */
    @ExcelProperty(value = "用户头像")
    private String userImg;

    /**
     * 评论内容
     */
    @ExcelProperty(value = "评论内容")
    private String content;

    /**
     * 点赞数
     */
    @ExcelProperty(value = "点赞数")
    private Integer giveLike;

    /**
     * 是否顶置(0: 正常、1: 顶置)
     */
    @ExcelProperty(value = "是否顶置(0: 正常、1: 顶置)")
    private Integer topMounted;

    /**
     * 类型(0: 评论文章、1: 回复评论)
     */
    @ExcelProperty(value = "类型(0: 评论文章、1: 回复评论)")
    private Integer type;

    /**
     * 文章id
     */
    @ExcelProperty(value = "文章id")
    private Long articleId;

    /**
     * 回复栏顶层评论用户id
     */
    @ExcelProperty(value = "回复栏顶层评论用户id")
    private Long replyTopId;

    /**
     * 回复的用户id
     */
    @ExcelProperty(value = "回复的用户id")
    private Long replyId;

    /**
     * 回复的用户名
     */
    @ExcelProperty(value = "回复的用户名")
    private String replyName;

    /**
     * 状态(0: 正常、1: 删除)
     */
    @ExcelProperty(value = "状态(0: 正常、1: 删除)")
    private Integer status;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createTime;


}
