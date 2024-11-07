package com.kaze.system.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.kaze.common.annotation.Log;
import com.kaze.common.annotation.RepeatSubmit;
import com.kaze.common.core.controller.BaseController;
import com.kaze.common.core.domain.PageQuery;
import com.kaze.common.core.domain.R;
import com.kaze.common.core.page.TableDataInfo;
import com.kaze.common.core.validate.AddGroup;
import com.kaze.common.core.validate.EditGroup;
import com.kaze.common.enums.BusinessType;
import com.kaze.common.utils.poi.ExcelUtil;
import com.kaze.system.domain.bo.BookEmailLogBo;
import com.kaze.system.domain.vo.BookEmailLogVo;
import com.kaze.system.service.IBookEmailLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * 邮件日志
 *
 * @author ruoyi
 * @date 2023-08-24
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/emailLog")
public class BookEmailLogController extends BaseController {

    private final IBookEmailLogService iBookEmailLogService;

    /**
     * 重发邮件
     */
    @SaCheckPermission("system:emailLog:list")
    @GetMapping("/restSend/{id}")
    public R<Void> restSend(@PathVariable("id") Long id) {
        return iBookEmailLogService.restSend(id);
    }

    /**
     * 查询邮件日志列表
     */
    @SaCheckPermission("system:emailLog:list")
    @GetMapping("/list")
    public TableDataInfo<BookEmailLogVo> list(BookEmailLogBo bo, PageQuery pageQuery) {
        return iBookEmailLogService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出邮件日志列表
     */
    @SaCheckPermission("system:emailLog:export")
    @Log(title = "邮件日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BookEmailLogBo bo, HttpServletResponse response) {
        List<BookEmailLogVo> list = iBookEmailLogService.queryList(bo);
        ExcelUtil.exportExcel(list, "邮件日志", BookEmailLogVo.class, response);
    }

    /**
     * 获取邮件日志详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:emailLog:query")
    @GetMapping("/{id}")
    public R<BookEmailLogVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iBookEmailLogService.queryById(id));
    }

    /**
     * 新增邮件日志
     */
    @SaCheckPermission("system:emailLog:add")
    @Log(title = "邮件日志", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BookEmailLogBo bo) {
        return toAjax(iBookEmailLogService.insertByBo(bo));
    }

    /**
     * 修改邮件日志
     */
    @SaCheckPermission("system:emailLog:edit")
    @Log(title = "邮件日志", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BookEmailLogBo bo) {
        return toAjax(iBookEmailLogService.updateByBo(bo));
    }

    /**
     * 删除邮件日志
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:emailLog:remove")
    @Log(title = "邮件日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iBookEmailLogService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
