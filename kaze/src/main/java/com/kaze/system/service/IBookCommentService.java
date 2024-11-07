package com.kaze.system.service;

import com.kaze.system.domain.BookComment;
import com.kaze.system.domain.vo.BookCommentVo;
import com.kaze.system.domain.bo.BookCommentBo;
import com.kaze.common.core.page.TableDataInfo;
import com.kaze.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 评论管理Service接口
 *
 * @author kaze
 * @date 2024-11-07
 */
public interface IBookCommentService {

    /**
     * 查询评论管理
     */
    BookCommentVo queryById(Long id);

    /**
     * 查询评论管理列表
     */
    TableDataInfo<BookCommentVo> queryPageList(BookCommentBo bo, PageQuery pageQuery);

    /**
     * 查询评论管理列表
     */
    List<BookCommentVo> queryList(BookCommentBo bo);

    /**
     * 新增评论管理
     */
    Boolean insertByBo(BookCommentBo bo);

    /**
     * 修改评论管理
     */
    Boolean updateByBo(BookCommentBo bo);

    /**
     * 校验并批量删除评论管理信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
