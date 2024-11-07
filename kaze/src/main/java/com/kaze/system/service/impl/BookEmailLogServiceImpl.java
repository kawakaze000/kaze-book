package com.kaze.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kaze.system.service.IBookEmailLogService;
import com.kaze.common.core.domain.PageQuery;
import com.kaze.common.core.domain.R;
import com.kaze.common.core.page.TableDataInfo;
import com.kaze.common.exception.ServiceException;
import com.kaze.common.utils.MessageUtils;
import com.kaze.common.utils.StringUtils;
import com.kaze.common.utils.email.MailUtils;
import com.kaze.system.domain.BookEmailLog;
import com.kaze.system.domain.bo.BookEmailLogBo;
import com.kaze.system.domain.vo.BookEmailLogVo;
import com.kaze.system.mapper.BookEmailLogMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 邮件日志Service业务层处理
 *
 * @author ruoyi
 * @date 2023-08-24
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class BookEmailLogServiceImpl implements IBookEmailLogService {

    private final BookEmailLogMapper baseMapper;

    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;
    /**
     * 查询邮件日志
     */
    @Override
    public BookEmailLogVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询邮件日志列表
     */
    @Override
    public TableDataInfo<BookEmailLogVo> queryPageList(BookEmailLogBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<BookEmailLog> lqw = buildQueryWrapper(bo);
        Page<BookEmailLogVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询邮件日志列表
     */
    @Override
    public List<BookEmailLogVo> queryList(BookEmailLogBo bo) {
        LambdaQueryWrapper<BookEmailLog> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<BookEmailLog> buildQueryWrapper(BookEmailLogBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<BookEmailLog> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getEmail()), BookEmailLog::getEmail, bo.getEmail());
        return lqw;
    }

    /**
     * 新增邮件日志
     */
    @Override
    public Boolean insertByBo(BookEmailLogBo bo) {
        BookEmailLog add = BeanUtil.toBean(bo, BookEmailLog.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改邮件日志
     */
    @Override
    public Boolean updateByBo(BookEmailLogBo bo) {
        BookEmailLog update = BeanUtil.toBean(bo, BookEmailLog.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(BookEmailLog entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除邮件日志
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }

    @Override
    public R<Void> restSend(Long id) {
        try {
            if (id == null) {
                throw new ServiceException(MessageUtils.message("log.id.not.null"));
            }

            BookEmailLog emailLog = baseMapper.selectById(id);

            if (ObjectUtils.isEmpty(emailLog)) {
                throw new ServiceException(MessageUtils.message("log.is.null"));
            }
            threadPoolTaskExecutor.execute(()->{
                MailUtils.sendText(emailLog.getEmail(), emailLog.getType(), emailLog.getContent());
            });
        } catch (Exception e) {
            log.error("验证码短信发送异常 => {}", e.getMessage());
            return R.fail(e.getMessage());
        }
        return R.ok();
    }
}
