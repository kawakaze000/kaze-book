package com.kaze.system.service;

import com.kaze.system.domain.BookUser;
import com.kaze.system.domain.vo.BookUserVo;
import com.kaze.system.domain.bo.BookUserBo;
import com.kaze.common.core.page.TableDataInfo;
import com.kaze.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 用户管理Service接口
 *
 * @author kaze
 * @date 2024-11-07
 */
public interface IBookUserService {

    /**
     * 查询用户管理
     */
    BookUserVo queryById(Long id);

    /**
     * 查询用户管理列表
     */
    TableDataInfo<BookUserVo> queryPageList(BookUserBo bo, PageQuery pageQuery);

    /**
     * 查询用户管理列表
     */
    List<BookUserVo> queryList(BookUserBo bo);

    /**
     * 新增用户管理
     */
    Boolean insertByBo(BookUserBo bo);

    /**
     * 修改用户管理
     */
    Boolean updateByBo(BookUserBo bo);

    /**
     * 校验并批量删除用户管理信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
