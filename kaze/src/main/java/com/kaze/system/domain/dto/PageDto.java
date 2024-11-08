package com.kaze.system.domain.dto;

import lombok.Data;

@Data
public class PageDto {
    /**
     * 第几页
     */
    private Integer pageNum = 1;
    /**
     * 每页条数
     */
    private Integer pageSize = 10;

    public Integer getBegin() {
        return (pageNum - 1) * pageSize;
    }
}
