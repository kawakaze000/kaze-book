package com.kaze.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.kaze.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 文章管理对象 book_article
 *
 * @author kaze
 * @date 2024-11-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("book_article")
public class BookArticle extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 作者id
     */
    private Long userId;
    /**
     * 作者名
     */
    private String userName;
    /**
     * 标题
     */
    private String title;
    /**
     * 封面图
     */
    private String coverImage;
    /**
     * 内容
     */
    private String content;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 是否顶置(0: 正常、1: 顶置)
     */
    private Integer topMounted;
    /**
     * 点赞数
     */
    private Integer giveLike;
    /**
     * 浏览量
     */
    private Integer viewVolume;
    /**
     * 收藏数
     */
    private Integer collection;
    /**
     * 评论数
     */
    private Integer comment;
    /**
     * 状态(0: 待审核、1: 通过、2: 驳回、3: 删除)
     */
    private Integer status;

}
