package com.kaze.system.domain.bo;

import com.kaze.common.core.domain.BaseEntity;
import com.kaze.common.core.validate.AddGroup;
import com.kaze.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

/**
 * 用户管理业务对象 book_user
 *
 * @author kaze
 * @date 2024-11-07
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class BookUserBo extends BaseEntity {

    /**
     * id
     */
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
    @NotBlank(message = "密码不能为空", groups = { AddGroup.class, EditGroup.class })
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
