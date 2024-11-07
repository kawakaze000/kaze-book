package com.kaze.system.controller;

import java.util.List;
import java.util.Arrays;

import lombok.RequiredArgsConstructor;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.kaze.common.annotation.RepeatSubmit;
import com.kaze.common.annotation.Log;
import com.kaze.common.core.controller.BaseController;
import com.kaze.common.core.domain.PageQuery;
import com.kaze.common.core.domain.R;
import com.kaze.common.core.validate.AddGroup;
import com.kaze.common.core.validate.EditGroup;
import com.kaze.common.enums.BusinessType;
import com.kaze.common.utils.poi.ExcelUtil;
import com.kaze.system.domain.vo.BookArticleVo;
import com.kaze.system.domain.bo.BookArticleBo;
import com.kaze.system.service.IBookArticleService;
import com.kaze.common.core.page.TableDataInfo;

/**
 * 文章管理
 *
 * @author kaze
 * @date 2024-11-07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/article")
public class BookArticleController extends BaseController {

    private final IBookArticleService iBookArticleService;

    /**
     * 查询文章管理列表
     */
    @SaCheckPermission("system:article:list")
    @GetMapping("/list")
    public TableDataInfo<BookArticleVo> list(BookArticleBo bo, PageQuery pageQuery) {
        return iBookArticleService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出文章管理列表
     */
    @SaCheckPermission("system:article:export")
    @Log(title = "文章管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BookArticleBo bo, HttpServletResponse response) {
        List<BookArticleVo> list = iBookArticleService.queryList(bo);
        ExcelUtil.exportExcel(list, "文章管理", BookArticleVo.class, response);
    }

    /**
     * 获取文章管理详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:article:query")
    @GetMapping("/{id}")
    public R<BookArticleVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iBookArticleService.queryById(id));
    }

    /**
     * 新增文章管理
     */
    @SaCheckPermission("system:article:add")
    @Log(title = "文章管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BookArticleBo bo) {
        return toAjax(iBookArticleService.insertByBo(bo));
    }

    /**
     * 修改文章管理
     */
    @SaCheckPermission("system:article:edit")
    @Log(title = "文章管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BookArticleBo bo) {
        return toAjax(iBookArticleService.updateByBo(bo));
    }

    /**
     * 删除文章管理
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:article:remove")
    @Log(title = "文章管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iBookArticleService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
