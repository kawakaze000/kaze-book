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
import com.kaze.system.domain.vo.BookFinancialRecordsVo;
import com.kaze.system.domain.bo.BookFinancialRecordsBo;
import com.kaze.system.service.IBookFinancialRecordsService;
import com.kaze.common.core.page.TableDataInfo;

/**
 * 账户明细
 *
 * @author kaze
 * @date 2024-11-07
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/financialRecords")
public class BookFinancialRecordsController extends BaseController {

    private final IBookFinancialRecordsService iBookFinancialRecordsService;

    /**
     * 查询账户明细列表
     */
    @SaCheckPermission("system:financialRecords:list")
    @GetMapping("/list")
    public TableDataInfo<BookFinancialRecordsVo> list(BookFinancialRecordsBo bo, PageQuery pageQuery) {
        return iBookFinancialRecordsService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出账户明细列表
     */
    @SaCheckPermission("system:financialRecords:export")
    @Log(title = "账户明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(BookFinancialRecordsBo bo, HttpServletResponse response) {
        List<BookFinancialRecordsVo> list = iBookFinancialRecordsService.queryList(bo);
        ExcelUtil.exportExcel(list, "账户明细", BookFinancialRecordsVo.class, response);
    }

    /**
     * 获取账户明细详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("system:financialRecords:query")
    @GetMapping("/{id}")
    public R<BookFinancialRecordsVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iBookFinancialRecordsService.queryById(id));
    }

    /**
     * 新增账户明细
     */
    @SaCheckPermission("system:financialRecords:add")
    @Log(title = "账户明细", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody BookFinancialRecordsBo bo) {
        return toAjax(iBookFinancialRecordsService.insertByBo(bo));
    }

    /**
     * 修改账户明细
     */
    @SaCheckPermission("system:financialRecords:edit")
    @Log(title = "账户明细", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody BookFinancialRecordsBo bo) {
        return toAjax(iBookFinancialRecordsService.updateByBo(bo));
    }

    /**
     * 删除账户明细
     *
     * @param ids 主键串
     */
    @SaCheckPermission("system:financialRecords:remove")
    @Log(title = "账户明细", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iBookFinancialRecordsService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}
