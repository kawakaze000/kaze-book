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
import com.kaze.system.domain.vo.BookLevelVo;
import com.kaze.system.domain.bo.BookLevelBo;
import com.kaze.system.service.IBookLevelService;
import com.kaze.common.core.page.TableDataInfo;

/**
 * 等级管理
 *
 * @author kaze
 * @date 2024-11-07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/level")
public class BookLevelController extends BaseController {

    private final IBookLevelService iBookLevelService;

    /**
     * 查询等级管理列表
     */
    @SaCheckPermission("system:level:list")
    @GetMapping("/list")
    public TableDataInfo<BookLevelVo> list(BookLevelBo bo, PageQuery pageQuery) {
        return iBookLevelService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出等级管理列表
     */
    @SaCheckPermission("system:level:export")
    @Log(title = "等级管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BookLevelBo bo, HttpServletResponse response) {
        List<BookLevelVo> list = iBookLevelService.queryList(bo);
        ExcelUtil.exportExcel(list, "等级管理", BookLevelVo.class, response);
    }

    /**
     * 获取等级管理详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:level:query")
    @GetMapping("/{id}")
    public R<BookLevelVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iBookLevelService.queryById(id));
    }

    /**
     * 新增等级管理
     */
    @SaCheckPermission("system:level:add")
    @Log(title = "等级管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BookLevelBo bo) {
        return toAjax(iBookLevelService.insertByBo(bo));
    }

    /**
     * 修改等级管理
     */
    @SaCheckPermission("system:level:edit")
    @Log(title = "等级管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BookLevelBo bo) {
        return toAjax(iBookLevelService.updateByBo(bo));
    }

    /**
     * 删除等级管理
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:level:remove")
    @Log(title = "等级管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iBookLevelService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
