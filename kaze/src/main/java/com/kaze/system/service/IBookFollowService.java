package com.kaze.system.service;

import com.kaze.system.domain.BookFollow;
import com.kaze.system.domain.vo.BookFollowVo;
import com.kaze.system.domain.bo.BookFollowBo;
import com.kaze.common.core.page.TableDataInfo;
import com.kaze.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2024-11-07
 */
public interface IBookFollowService {

    /**
     * 查询【请填写功能名称】
     */
    BookFollowVo queryById(Long id);

    /**
     * 查询【请填写功能名称】列表
     */
    TableDataInfo<BookFollowVo> queryPageList(BookFollowBo bo, PageQuery pageQuery);

    /**
     * 查询【请填写功能名称】列表
     */
    List<BookFollowVo> queryList(BookFollowBo bo);

    /**
     * 新增【请填写功能名称】
     */
    Boolean insertByBo(BookFollowBo bo);

    /**
     * 修改【请填写功能名称】
     */
    Boolean updateByBo(BookFollowBo bo);

    /**
     * 校验并批量删除【请填写功能名称】信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
