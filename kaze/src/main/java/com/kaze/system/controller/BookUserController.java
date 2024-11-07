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
import com.kaze.system.domain.vo.BookUserVo;
import com.kaze.system.domain.bo.BookUserBo;
import com.kaze.system.service.IBookUserService;
import com.kaze.common.core.page.TableDataInfo;

/**
 * 用户管理
 *
 * @author kaze
 * @date 2024-11-07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/bookUser")
public class BookUserController extends BaseController {

    private final IBookUserService iBookUserService;

    /**
     * 查询用户管理列表
     */
    @SaCheckPermission("system:user:list")
    @GetMapping("/list")
    public TableDataInfo<BookUserVo> list(BookUserBo bo, PageQuery pageQuery) {
        return iBookUserService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出用户管理列表
     */
    @SaCheckPermission("system:user:export")
    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BookUserBo bo, HttpServletResponse response) {
        List<BookUserVo> list = iBookUserService.queryList(bo);
        ExcelUtil.exportExcel(list, "用户管理", BookUserVo.class, response);
    }

    /**
     * 获取用户管理详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:user:query")
    @GetMapping("/{id}")
    public R<BookUserVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iBookUserService.queryById(id));
    }

    /**
     * 新增用户管理
     */
    @SaCheckPermission("system:user:add")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BookUserBo bo) {
        return toAjax(iBookUserService.insertByBo(bo));
    }

    /**
     * 修改用户管理
     */
    @SaCheckPermission("system:user:edit")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BookUserBo bo) {
        return toAjax(iBookUserService.updateByBo(bo));
    }

    /**
     * 删除用户管理
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:user:remove")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iBookUserService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
