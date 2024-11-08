package com.kaze.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaze.common.exception.ServiceException;
import com.kaze.system.domain.BookArticle;
import com.kaze.system.domain.dto.PageDto;
import com.kaze.system.mapper.BookArticleMapper;
import com.kaze.system.service.IIndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.kaze.system.enums.ErrorCode.ARTICLE_ID_NOT_NULL;

/**
 * @author chen
 * @version V1.0
 * @since 2024/11/7 16:36
 */
@RequiredArgsConstructor
@Service
public class IndexServiceImpl implements IIndexService {

    private final BookArticleMapper articleMapper;

    @Override
    public Page<BookArticle> getArticlePageList(PageDto dto) {
        return articleMapper.selectPage(new Page<>(dto.getPageNum(), dto.getPageSize()), new LambdaQueryWrapper<BookArticle>().eq(BookArticle::getStatus, 1).orderByDesc(BookArticle::getCreateTime));
    }

    @Override
    public BookArticle getArticleById(Long id) {
        if (id == null) throw new ServiceException(ARTICLE_ID_NOT_NULL.getMsg(), ARTICLE_ID_NOT_NULL.getCode());
        return articleMapper.selectById(id);
    }

}
