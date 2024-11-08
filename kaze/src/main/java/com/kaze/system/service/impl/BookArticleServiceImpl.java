package com.kaze.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.kaze.common.core.domain.entity.SysUser;
import com.kaze.common.core.page.TableDataInfo;
import com.kaze.common.core.domain.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kaze.common.utils.StringUtils;
import com.kaze.system.domain.SysOss;
import com.kaze.system.mapper.SysOssMapper;
import com.kaze.system.mapper.SysUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.kaze.system.domain.bo.BookArticleBo;
import com.kaze.system.domain.vo.BookArticleVo;
import com.kaze.system.domain.BookArticle;
import com.kaze.system.mapper.BookArticleMapper;
import com.kaze.system.service.IBookArticleService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 文章管理Service业务层处理
 *
 * @author kaze
 * @date 2024-11-07
 */
@RequiredArgsConstructor
@Service
public class BookArticleServiceImpl implements IBookArticleService {

    private final BookArticleMapper baseMapper;

    private final SysUserMapper userMapper;

    private final SysOssMapper ossMapper;

    /**
     * 查询文章管理
     */
    @Override
    public BookArticleVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询文章管理列表
     */
    @Override
    public TableDataInfo<BookArticleVo> queryPageList(BookArticleBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BookArticle> lqw = buildQueryWrapper(bo);
        Page<BookArticleVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询文章管理列表
     */
    @Override
    public List<BookArticleVo> queryList(BookArticleBo bo) {
        LambdaQueryWrapper<BookArticle> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BookArticle> buildQueryWrapper(BookArticleBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BookArticle> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getUserId() != null, BookArticle::getUserId, bo.getUserId());
        lqw.like(StringUtils.isNotBlank(bo.getUserName()), BookArticle::getUserName, bo.getUserName());
        lqw.like(StringUtils.isNotBlank(bo.getTitle()), BookArticle::getTitle, bo.getTitle());
        lqw.eq(bo.getType() != null, BookArticle::getType, bo.getType());
        lqw.eq(bo.getTopMounted() != null, BookArticle::getTopMounted, bo.getTopMounted());
        lqw.ge(bo.getGiveLike() != null, BookArticle::getGiveLike, bo.getGiveLike());
        lqw.ge(bo.getViewVolume() != null, BookArticle::getViewVolume, bo.getViewVolume());
        lqw.ge(bo.getCollection() != null, BookArticle::getCollection, bo.getCollection());
        lqw.ge(bo.getComment() != null, BookArticle::getComment, bo.getComment());
        lqw.eq(bo.getStatus() != null, BookArticle::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增文章管理
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertByBo(BookArticleBo bo) {
        BookArticle add = setOssUrl(bo);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改文章管理
     */
    @Override
    public Boolean updateByBo(BookArticleBo bo) {
        BookArticle update = setOssUrl(bo);
        return baseMapper.updateById(update) > 0;
    }

    public BookArticle setOssUrl(BookArticleBo bo){
        BookArticle bookArticle = BeanUtil.toBean(bo, BookArticle.class);
        validEntityBeforeSave(bookArticle);
        SysOss oss = ossMapper.selectById(bo.getCoverImage());
        bookArticle.setCoverImageUrl(oss.getUrl());
        return bookArticle;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BookArticle entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除文章管理
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
