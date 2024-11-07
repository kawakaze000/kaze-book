package com.kaze.system.service;

import com.kaze.system.domain.BookLevel;
import com.kaze.system.domain.vo.BookLevelVo;
import com.kaze.system.domain.bo.BookLevelBo;
import com.kaze.common.core.page.TableDataInfo;
import com.kaze.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 等级管理Service接口
 *
 * @author kaze
 * @date 2024-11-07
 */
public interface IBookLevelService {

    /**
     * 查询等级管理
     */
    BookLevelVo queryById(Long id);

    /**
     * 查询等级管理列表
     */
    TableDataInfo<BookLevelVo> queryPageList(BookLevelBo bo, PageQuery pageQuery);

    /**
     * 查询等级管理列表
     */
    List<BookLevelVo> queryList(BookLevelBo bo);

    /**
     * 新增等级管理
     */
    Boolean insertByBo(BookLevelBo bo);

    /**
     * 修改等级管理
     */
    Boolean updateByBo(BookLevelBo bo);

    /**
     * 校验并批量删除等级管理信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
