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
import com.kaze.system.domain.vo.BookFollowVo;
import com.kaze.system.domain.bo.BookFollowBo;
import com.kaze.system.service.IBookFollowService;
import com.kaze.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】
 *
 * @author ruoyi
 * @date 2024-11-07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/follow")
public class BookFollowController extends BaseController {

    private final IBookFollowService iBookFollowService;

    /**
     * 查询【请填写功能名称】列表
     */
    @SaCheckPermission("system:follow:list")
    @GetMapping("/list")
    public TableDataInfo<BookFollowVo> list(BookFollowBo bo, PageQuery pageQuery) {
        return iBookFollowService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @SaCheckPermission("system:follow:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BookFollowBo bo, HttpServletResponse response) {
        List<BookFollowVo> list = iBookFollowService.queryList(bo);
        ExcelUtil.exportExcel(list, "【请填写功能名称】", BookFollowVo.class, response);
    }

    /**
     * 获取【请填写功能名称】详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:follow:query")
    @GetMapping("/{id}")
    public R<BookFollowVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iBookFollowService.queryById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @SaCheckPermission("system:follow:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BookFollowBo bo) {
        return toAjax(iBookFollowService.insertByBo(bo));
    }

    /**
     * 修改【请填写功能名称】
     */
    @SaCheckPermission("system:follow:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BookFollowBo bo) {
        return toAjax(iBookFollowService.updateByBo(bo));
    }

    /**
     * 删除【请填写功能名称】
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:follow:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iBookFollowService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
