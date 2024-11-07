package com.kaze.system.service;

import com.kaze.system.domain.BookArticle;
import com.kaze.system.domain.vo.BookArticleVo;
import com.kaze.system.domain.bo.BookArticleBo;
import com.kaze.common.core.page.TableDataInfo;
import com.kaze.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 文章管理Service接口
 *
 * @author kaze
 * @date 2024-11-07
 */
public interface IBookArticleService {

    /**
     * 查询文章管理
     */
    BookArticleVo queryById(Long id);

    /**
     * 查询文章管理列表
     */
    TableDataInfo<BookArticleVo> queryPageList(BookArticleBo bo, PageQuery pageQuery);

    /**
     * 查询文章管理列表
     */
    List<BookArticleVo> queryList(BookArticleBo bo);

    /**
     * 新增文章管理
     */
    Boolean insertByBo(BookArticleBo bo);

    /**
     * 修改文章管理
     */
    Boolean updateByBo(BookArticleBo bo);

    /**
     * 校验并批量删除文章管理信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
