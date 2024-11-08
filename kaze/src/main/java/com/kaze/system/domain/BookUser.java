package com.kaze.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.kaze.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户管理对象 book_user
 *
 * @author kaze
 * @date 2024-11-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("book_user")
public class BookUser extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 昵称
     */
    private String name;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 头像
     */
    private String img;
    /**
     * 勋章
     */
    private Integer medal;
    /**
     * 等级
     */
    private Integer level;
    /**
     * 经验值
     */
    private Integer exp;
    /**
     * vip
     */
    private Date vip;
    /**
     * 认证
     */
    private String authentication;
    /**
     * 关注数
     */
    private Integer follow;
    /**
     * 粉丝数
     */
    private Integer fans;
    /**
     * 文章数
     */
    private Integer article;
    /**
     * 用户类型
     */
    private Integer type;

}
