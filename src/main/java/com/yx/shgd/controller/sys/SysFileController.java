package com.yx.shgd.controller.sys;

import com.yx.shgd.model.vo.sys.SysFileVo;
import com.yx.shgd.service.sys.ISysFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/sys/file")
@Api(value = "file", tags = "文件管理模块")
public class SysFileController {

    @Resource
    private ISysFileService sysFileService;

    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public SysFileVo upload(MultipartFile file) {
        return sysFileService.upload(file);
    }
}
