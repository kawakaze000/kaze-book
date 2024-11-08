package com.kaze.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaze.system.domain.BookArticle;
import com.kaze.system.domain.dto.PageDto;

/**
 * @author chen
 * @version V1.0
 * @since 2024/11/7 16:36
 */
public interface IIndexService {
    Page<BookArticle> getArticlePageList(PageDto dto);

    BookArticle getArticleById(Long id);
}
