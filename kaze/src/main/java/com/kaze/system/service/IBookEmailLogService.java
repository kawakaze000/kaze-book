package com.kaze.system.service;

import com.kaze.common.core.domain.PageQuery;
import com.kaze.common.core.domain.R;
import com.kaze.common.core.page.TableDataInfo;
import com.kaze.system.domain.bo.BookEmailLogBo;
import com.kaze.system.domain.vo.BookEmailLogVo;

import java.util.Collection;
import java.util.List;

/**
 * 邮件日志Service接口
 *
 * @author ruoyi
 * @date 2023-08-24
 */
public interface IBookEmailLogService {

    /**
     * 查询邮件日志
     */
    BookEmailLogVo queryById(Long id);

    /**
     * 查询邮件日志列表
     */
    TableDataInfo<BookEmailLogVo> queryPageList(BookEmailLogBo bo, PageQuery pageQuery);

    /**
     * 查询邮件日志列表
     */
    List<BookEmailLogVo> queryList(BookEmailLogBo bo);

    /**
     * 新增邮件日志
     */
    Boolean insertByBo(BookEmailLogBo bo);

    /**
     * 修改邮件日志
     */
    Boolean updateByBo(BookEmailLogBo bo);

    /**
     * 校验并批量删除邮件日志信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);

    /**
     * 重发邮件
     */
    R<Void> restSend(Long id);

}
