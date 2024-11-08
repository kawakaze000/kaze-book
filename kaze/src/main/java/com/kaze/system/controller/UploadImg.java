package com.kaze.system.controller;

import com.kaze.common.core.domain.R;
import com.kaze.system.domain.vo.SysOssVo;
import com.kaze.system.domain.vo.UploadVo;
import com.kaze.system.service.ISysOssService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @version V1.0
 * @since 2023/3/28 16:55
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/common/upload")
public class UploadImg {

    private final ISysOssService iSysOssService;

    /**
     * 上传图片 返回图片url
     */
    @PostMapping("/img")
    public R<UploadVo> upload(MultipartFile file) throws IOException {
        SysOssVo upload = iSysOssService.upload(file);
        return R.ok(UploadVo.builder().url(upload.getUrl()).build());
    }

}
