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
import com.kaze.system.domain.vo.BookCommentVo;
import com.kaze.system.domain.bo.BookCommentBo;
import com.kaze.system.service.IBookCommentService;
import com.kaze.common.core.page.TableDataInfo;

/**
 * 评论管理
 *
 * @author kaze
 * @date 2024-11-07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/comment")
public class BookCommentController extends BaseController {

    private final IBookCommentService iBookCommentService;

    /**
     * 查询评论管理列表
     */
    @SaCheckPermission("system:comment:list")
    @GetMapping("/list")
    public TableDataInfo<BookCommentVo> list(BookCommentBo bo, PageQuery pageQuery) {
        return iBookCommentService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出评论管理列表
     */
    @SaCheckPermission("system:comment:export")
    @Log(title = "评论管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BookCommentBo bo, HttpServletResponse response) {
        List<BookCommentVo> list = iBookCommentService.queryList(bo);
        ExcelUtil.exportExcel(list, "评论管理", BookCommentVo.class, response);
    }

    /**
     * 获取评论管理详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:comment:query")
    @GetMapping("/{id}")
    public R<BookCommentVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iBookCommentService.queryById(id));
    }

    /**
     * 新增评论管理
     */
    @SaCheckPermission("system:comment:add")
    @Log(title = "评论管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BookCommentBo bo) {
        return toAjax(iBookCommentService.insertByBo(bo));
    }

    /**
     * 修改评论管理
     */
    @SaCheckPermission("system:comment:edit")
    @Log(title = "评论管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BookCommentBo bo) {
        return toAjax(iBookCommentService.updateByBo(bo));
    }

    /**
     * 删除评论管理
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:comment:remove")
    @Log(title = "评论管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iBookCommentService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
