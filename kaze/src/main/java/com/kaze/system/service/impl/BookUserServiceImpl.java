package com.kaze.system.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.hutool.core.bean.BeanUtil;
import com.kaze.common.core.page.TableDataInfo;
import com.kaze.common.core.domain.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kaze.common.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.kaze.system.domain.bo.BookUserBo;
import com.kaze.system.domain.vo.BookUserVo;
import com.kaze.system.domain.BookUser;
import com.kaze.system.mapper.BookUserMapper;
import com.kaze.system.service.IBookUserService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 用户管理Service业务层处理
 *
 * @author kaze
 * @date 2024-11-07
 */
@RequiredArgsConstructor
@Service
public class BookUserServiceImpl implements IBookUserService {

    private final BookUserMapper baseMapper;

    /**
     * 查询用户管理
     */
    @Override
    public BookUserVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询用户管理列表
     */
    @Override
    public TableDataInfo<BookUserVo> queryPageList(BookUserBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BookUser> lqw = buildQueryWrapper(bo);
        Page<BookUserVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询用户管理列表
     */
    @Override
    public List<BookUserVo> queryList(BookUserBo bo) {
        LambdaQueryWrapper<BookUser> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BookUser> buildQueryWrapper(BookUserBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BookUser> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getName()), BookUser::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getEmail()), BookUser::getEmail, bo.getEmail());
        lqw.eq(StringUtils.isNotBlank(bo.getPassword()), BookUser::getPassword, bo.getPassword());
        lqw.eq(StringUtils.isNotBlank(bo.getImg()), BookUser::getImg, bo.getImg());
        lqw.eq(bo.getMedal() != null, BookUser::getMedal, bo.getMedal());
        lqw.eq(bo.getLevel() != null, BookUser::getLevel, bo.getLevel());
        lqw.eq(bo.getType() != null, BookUser::getType, bo.getType());
        lqw.eq(StringUtils.isNotBlank(bo.getAuthentication()), BookUser::getAuthentication, bo.getAuthentication());
        lqw.ge(bo.getFans() != null, BookUser::getFans, bo.getFans());
        lqw.ge(bo.getArticle() != null, BookUser::getArticle, bo.getArticle());
        return lqw;
    }

    /**
     * 新增用户管理
     */
    @Override
    public Boolean insertByBo(BookUserBo bo) {
        BookUser add = BeanUtil.toBean(bo, BookUser.class);
        validEntityBeforeSave(add);

        add.setType(1);
        add.setPassword(BCrypt.hashpw("123456"));

        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改用户管理
     */
    @Override
    public Boolean updateByBo(BookUserBo bo) {
        BookUser update = BeanUtil.toBean(bo, BookUser.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BookUser entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除用户管理
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
