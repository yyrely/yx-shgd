package com.yx.shgd.service.sys.impl;

import cn.hutool.core.text.CharSequenceUtil;
import com.yx.shgd.common.exception.ServiceException;
import com.yx.shgd.model.vo.sys.SysFileVo;
import com.yx.shgd.service.sys.ISysFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
public class SysFileServiceImpl implements ISysFileService {

    @Value("${file.path}")
    private String filePath;

    @Value("${file.mapper}")
    private String fileMapper;


    @Override
    public SysFileVo upload(MultipartFile file, HttpServletRequest request) {
        if(Objects.isNull(file)) {
            throw new ServiceException("上传文件为空");
        }
        // 获取文件的原始名称
        String originalFileName = file.getOriginalFilename();
        if(CharSequenceUtil.isEmpty(originalFileName)) {
            throw new ServiceException("文件名不能为空");
        }
        String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
        String date = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        // 生成存储文件的目标路径 (例如: 本地的某个目录)
        String uploadDirectory = filePath + date;
        File targetFile = new File(uploadDirectory, newFileName);

        try {
            // 确保目标目录存在，不存在则创建
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }
            // 使用 MultipartFile 提供的 transferTo 方法直接将文件写入到目标文件中
            file.transferTo(targetFile);

            // 构建并返回自定义的 SysFileVo 对象（假设 SysFileVo 包含文件相关信息）
            SysFileVo sysFileVo = new SysFileVo();
            sysFileVo.setName(originalFileName);
            sysFileVo.setPath(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + fileMapper + date + "/" + newFileName);
            return sysFileVo;
        } catch (Exception e) {
            // 捕获并处理异常
            log.error("文件上传失败", e);
            throw new ServiceException("文件上传失败:" + e.getMessage());
        }
    }
}
