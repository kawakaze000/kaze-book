package com.kaze.system.domain.bo;

import com.kaze.common.core.domain.BaseEntity;
import com.kaze.common.core.validate.AddGroup;
import com.kaze.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;


/**
 * 【请填写功能名称】业务对象 book_follow
 *
 * @author ruoyi
 * @date 2024-11-07
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class BookFollowBo extends BaseEntity {

    /**
     * 
     */
    @NotNull(message = "不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long userId;

    /**
     * 关注者id
     */
    @NotNull(message = "关注者id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long followId;

    /**
     * 粉丝id
     */
    @NotNull(message = "粉丝id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long fanId;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String userName;

    /**
     * 用户头像
     */
    @NotBlank(message = "用户头像不能为空", groups = { AddGroup.class, EditGroup.class })
    private String userImg;


}
