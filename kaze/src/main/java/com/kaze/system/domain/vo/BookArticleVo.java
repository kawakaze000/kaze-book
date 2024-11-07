package com.kaze.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.kaze.common.annotation.ExcelDictFormat;
import com.kaze.common.convert.ExcelDictConvert;
import lombok.Data;

import java.util.Date;


/**
 * 文章管理视图对象 book_article
 *
 * @author kaze
 * @date 2024-11-07
 */
@Data
@ExcelIgnoreUnannotated
public class BookArticleVo {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 作者id
     */
    @ExcelProperty(value = "作者id")
    private Long userId;

    /**
     * 作者名
     */
    @ExcelProperty(value = "作者名")
    private String userName;

    /**
     * 标题
     */
    @ExcelProperty(value = "标题")
    private String title;

    /**
     * 封面图
     */
    @ExcelProperty(value = "封面图")
    private String coverImage;

    /**
     * 内容
     */
    @ExcelProperty(value = "内容")
    private String content;

    /**
     * 类型
     */
    @ExcelProperty(value = "类型")
    private Integer type;

    /**
     * 是否顶置(0: 正常、1: 顶置)
     */
    @ExcelProperty(value = "是否顶置(0: 正常、1: 顶置)")
    private Integer topMounted;

    /**
     * 点赞数
     */
    @ExcelProperty(value = "点赞数")
    private Integer giveLike;

    /**
     * 浏览量
     */
    @ExcelProperty(value = "浏览量")
    private Integer viewVolume;

    /**
     * 收藏数
     */
    @ExcelProperty(value = "收藏数")
    private Integer collection;

    /**
     * 评论数
     */
    @ExcelProperty(value = "评论数")
    private Integer comment;

    /**
     * 状态(0: 待审核、1: 通过、2: 驳回、3: 删除)
     */
    @ExcelProperty(value = "状态(0: 待审核、1: 通过、2: 驳回、3: 删除)")
    private Integer status;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createTime;


}
