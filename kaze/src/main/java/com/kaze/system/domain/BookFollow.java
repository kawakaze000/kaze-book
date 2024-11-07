package com.kaze.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.kaze.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 【请填写功能名称】对象 book_follow
 *
 * @author ruoyi
 * @date 2024-11-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("book_follow")
public class BookFollow extends BaseEntity {

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
     * 关注者id
     */
    private Long followId;
    /**
     * 粉丝id
     */
    private Long fanId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户头像
     */
    private String userImg;

}
