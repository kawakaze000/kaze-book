package com.kaze.system.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaze.common.core.domain.R;
import com.kaze.system.domain.BookArticle;
import com.kaze.system.domain.dto.PageDto;
import com.kaze.system.service.IIndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author chen
 * @version V1.0
 * @since 2024/11/7 15:09
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/index")
public class IndexController {

    @Autowired
    private IIndexService indexService;

    @PostMapping("/articlePageList")
    @SaIgnore
    public R<Page<BookArticle>> getArticlePageList(@RequestBody PageDto dto) {
        return R.ok(indexService.getArticlePageList(dto));
    }

    @GetMapping("/getArticleById/{id}")
    @SaIgnore
    public R<BookArticle> getArticleById(@PathVariable("id") Long id) {
        return R.ok(indexService.getArticleById(id));
    }

}
