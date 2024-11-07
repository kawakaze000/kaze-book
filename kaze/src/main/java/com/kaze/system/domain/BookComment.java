package com.kaze.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.kaze.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 评论管理对象 book_comment
 *
 * @author kaze
 * @date 2024-11-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("book_comment")
public class BookComment extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * id
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
     * 用户头像
     */
    private String userImg;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 点赞数
     */
    private Integer giveLike;
    /**
     * 是否顶置(0: 正常、1: 顶置)
     */
    private Integer topMounted;
    /**
     * 类型(0: 评论文章、1: 回复评论)
     */
    private Integer type;
    /**
     * 文章id
     */
    private Long articleId;
    /**
     * 回复栏顶层评论用户id
     */
    private Long replyTopId;
    /**
     * 回复的用户id
     */
    private Long replyId;
    /**
     * 回复的用户名
     */
    private String replyName;
    /**
     * 状态(0: 正常、1: 删除)
     */
    private Integer status;

}
