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
import com.kaze.system.domain.bo.BookFinancialRecordsBo;
import com.kaze.system.domain.vo.BookFinancialRecordsVo;
import com.kaze.system.domain.BookFinancialRecords;
import com.kaze.system.mapper.BookFinancialRecordsMapper;
import com.kaze.system.service.IBookFinancialRecordsService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 账户明细Service业务层处理
 *
 * @author kaze
 * @date 2024-11-07
 */
@RequiredArgsConstructor
@Service
public class BookFinancialRecordsServiceImpl implements IBookFinancialRecordsService {

    private final BookFinancialRecordsMapper baseMapper;

    /**
     * 查询账户明细
     */
    @Override
    public BookFinancialRecordsVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询账户明细列表
     */
    @Override
    public TableDataInfo<BookFinancialRecordsVo> queryPageList(BookFinancialRecordsBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BookFinancialRecords> lqw = buildQueryWrapper(bo);
        Page<BookFinancialRecordsVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询账户明细列表
     */
    @Override
    public List<BookFinancialRecordsVo> queryList(BookFinancialRecordsBo bo) {
        LambdaQueryWrapper<BookFinancialRecords> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BookFinancialRecords> buildQueryWrapper(BookFinancialRecordsBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BookFinancialRecords> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getUserName()), BookFinancialRecords::getUserName, bo.getUserName());
        lqw.eq(bo.getType() != null, BookFinancialRecords::getType, bo.getType());
        lqw.eq(bo.getPayType() != null, BookFinancialRecords::getPayType, bo.getPayType());
        return lqw;
    }

    /**
     * 新增账户明细
     */
    @Override
    public Boolean insertByBo(BookFinancialRecordsBo bo) {
        BookFinancialRecords add = BeanUtil.toBean(bo, BookFinancialRecords.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改账户明细
     */
    @Override
    public Boolean updateByBo(BookFinancialRecordsBo bo) {
        BookFinancialRecords update = BeanUtil.toBean(bo, BookFinancialRecords.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BookFinancialRecords entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除账户明细
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
