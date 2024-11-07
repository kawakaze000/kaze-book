package com.kaze.system.domain.bo;

import com.kaze.common.core.domain.BaseEntity;
import com.kaze.common.core.validate.AddGroup;
import com.kaze.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;


/**
 * 等级管理业务对象 book_level
 *
 * @author kaze
 * @date 2024-11-07
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class BookLevelBo extends BaseEntity {

    /**
     * id
     */
    private Long id;

    /**
     * 等级
     */
    @NotNull(message = "等级不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer level;

    /**
     * 等级名称
     */
    @NotBlank(message = "等级名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String levelName;

    /**
     * 经验值
     */
    @NotNull(message = "经验值不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer exp;


}
