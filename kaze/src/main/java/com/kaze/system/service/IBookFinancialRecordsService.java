package com.kaze.system.service;

import com.kaze.system.domain.BookFinancialRecords;
import com.kaze.system.domain.vo.BookFinancialRecordsVo;
import com.kaze.system.domain.bo.BookFinancialRecordsBo;
import com.kaze.common.core.page.TableDataInfo;
import com.kaze.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 账户明细Service接口
 *
 * @author kaze
 * @date 2024-11-07
 */
public interface IBookFinancialRecordsService {

    /**
     * 查询账户明细
     */
    BookFinancialRecordsVo queryById(Long id);

    /**
     * 查询账户明细列表
     */
    TableDataInfo<BookFinancialRecordsVo> queryPageList(BookFinancialRecordsBo bo, PageQuery pageQuery);

    /**
     * 查询账户明细列表
     */
    List<BookFinancialRecordsVo> queryList(BookFinancialRecordsBo bo);

    /**
     * 新增账户明细
     */
    Boolean insertByBo(BookFinancialRecordsBo bo);

    /**
     * 修改账户明细
     */
    Boolean updateByBo(BookFinancialRecordsBo bo);

    /**
     * 校验并批量删除账户明细信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
