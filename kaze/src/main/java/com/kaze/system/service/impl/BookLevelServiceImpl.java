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
import com.kaze.system.domain.bo.BookLevelBo;
import com.kaze.system.domain.vo.BookLevelVo;
import com.kaze.system.domain.BookLevel;
import com.kaze.system.mapper.BookLevelMapper;
import com.kaze.system.service.IBookLevelService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 等级管理Service业务层处理
 *
 * @author kaze
 * @date 2024-11-07
 */
@RequiredArgsConstructor
@Service
public class BookLevelServiceImpl implements IBookLevelService {

    private final BookLevelMapper baseMapper;

    /**
     * 查询等级管理
     */
    @Override
    public BookLevelVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询等级管理列表
     */
    @Override
    public TableDataInfo<BookLevelVo> queryPageList(BookLevelBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BookLevel> lqw = buildQueryWrapper(bo);
        Page<BookLevelVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询等级管理列表
     */
    @Override
    public List<BookLevelVo> queryList(BookLevelBo bo) {
        LambdaQueryWrapper<BookLevel> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BookLevel> buildQueryWrapper(BookLevelBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BookLevel> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getLevel() != null, BookLevel::getLevel, bo.getLevel());
        lqw.like(StringUtils.isNotBlank(bo.getLevelName()), BookLevel::getLevelName, bo.getLevelName());
        return lqw;
    }

    /**
     * 新增等级管理
     */
    @Override
    public Boolean insertByBo(BookLevelBo bo) {
        BookLevel add = BeanUtil.toBean(bo, BookLevel.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改等级管理
     */
    @Override
    public Boolean updateByBo(BookLevelBo bo) {
        BookLevel update = BeanUtil.toBean(bo, BookLevel.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BookLevel entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除等级管理
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
