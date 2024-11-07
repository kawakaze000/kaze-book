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
import com.kaze.system.domain.bo.BookFollowBo;
import com.kaze.system.domain.vo.BookFollowVo;
import com.kaze.system.domain.BookFollow;
import com.kaze.system.mapper.BookFollowMapper;
import com.kaze.system.service.IBookFollowService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2024-11-07
 */
@RequiredArgsConstructor
@Service
public class BookFollowServiceImpl implements IBookFollowService {

    private final BookFollowMapper baseMapper;

    /**
     * 查询【请填写功能名称】
     */
    @Override
    public BookFollowVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @Override
    public TableDataInfo<BookFollowVo> queryPageList(BookFollowBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BookFollow> lqw = buildQueryWrapper(bo);
        Page<BookFollowVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @Override
    public List<BookFollowVo> queryList(BookFollowBo bo) {
        LambdaQueryWrapper<BookFollow> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BookFollow> buildQueryWrapper(BookFollowBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BookFollow> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getUserId() != null, BookFollow::getUserId, bo.getUserId());
        lqw.eq(bo.getFollowId() != null, BookFollow::getFollowId, bo.getFollowId());
        lqw.eq(bo.getFanId() != null, BookFollow::getFanId, bo.getFanId());
        lqw.like(StringUtils.isNotBlank(bo.getUserName()), BookFollow::getUserName, bo.getUserName());
        lqw.eq(StringUtils.isNotBlank(bo.getUserImg()), BookFollow::getUserImg, bo.getUserImg());
        return lqw;
    }

    /**
     * 新增【请填写功能名称】
     */
    @Override
    public Boolean insertByBo(BookFollowBo bo) {
        BookFollow add = BeanUtil.toBean(bo, BookFollow.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改【请填写功能名称】
     */
    @Override
    public Boolean updateByBo(BookFollowBo bo) {
        BookFollow update = BeanUtil.toBean(bo, BookFollow.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BookFollow entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除【请填写功能名称】
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
