package com.kaze.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.kaze.common.core.page.TableDataInfo;
import com.kaze.common.core.domain.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kaze.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.kaze.system.domain.bo.BookCommentBo;
import com.kaze.system.domain.vo.BookCommentVo;
import com.kaze.system.domain.BookComment;
import com.kaze.system.mapper.BookCommentMapper;
import com.kaze.system.service.IBookCommentService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 评论管理Service业务层处理
 *
 * @author kaze
 * @date 2024-11-07
 */
@RequiredArgsConstructor
@Service
public class BookCommentServiceImpl implements IBookCommentService {

    private final BookCommentMapper baseMapper;

    /**
     * 查询评论管理
     */
    @Override
    public BookCommentVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询评论管理列表
     */
    @Override
    public TableDataInfo<BookCommentVo> queryPageList(BookCommentBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BookComment> lqw = buildQueryWrapper(bo);
        Page<BookCommentVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询评论管理列表
     */
    @Override
    public List<BookCommentVo> queryList(BookCommentBo bo) {
        LambdaQueryWrapper<BookComment> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BookComment> buildQueryWrapper(BookCommentBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BookComment> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getUserName()), BookComment::getUserName, bo.getUserName());
        lqw.eq(StringUtils.isNotBlank(bo.getUserImg()), BookComment::getUserImg, bo.getUserImg());
        lqw.eq(StringUtils.isNotBlank(bo.getContent()), BookComment::getContent, bo.getContent());
        lqw.ge(bo.getGiveLike() != null, BookComment::getGiveLike, bo.getGiveLike());
        lqw.eq(bo.getTopMounted() != null, BookComment::getTopMounted, bo.getTopMounted());
        lqw.eq(bo.getType() != null, BookComment::getType, bo.getType());
        lqw.like(StringUtils.isNotBlank(bo.getReplyName()), BookComment::getReplyName, bo.getReplyName());
        lqw.eq(bo.getStatus() != null, BookComment::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增评论管理
     */
    @Override
    public Boolean insertByBo(BookCommentBo bo) {
        BookComment add = BeanUtil.toBean(bo, BookComment.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改评论管理
     */
    @Override
    public Boolean updateByBo(BookCommentBo bo) {
        BookComment update = BeanUtil.toBean(bo, BookComment.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BookComment entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除评论管理
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
