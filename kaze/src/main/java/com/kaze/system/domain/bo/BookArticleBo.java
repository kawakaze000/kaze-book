package com.kaze.system.domain.bo;

import com.kaze.common.core.domain.BaseEntity;
import com.kaze.common.core.validate.AddGroup;
import com.kaze.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;


/**
 * 文章管理业务对象 book_article
 *
 * @author kaze
 * @date 2024-11-07
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class BookArticleBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "id不能为空", groups = { EditGroup.class })
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
    private Long coverImage;

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
    @NotNull(message = "是否顶置(0: 正常、1: 顶置)不能为空", groups = { AddGroup.class, EditGroup.class })
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
