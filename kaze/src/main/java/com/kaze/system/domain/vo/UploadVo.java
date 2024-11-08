package com.kaze.system.domain.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UploadVo {
    /**
     * 图片url
     */
    private String url;
}
