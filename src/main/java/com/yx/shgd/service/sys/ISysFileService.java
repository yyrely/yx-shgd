package com.yx.shgd.service.sys;

import com.yx.shgd.model.vo.sys.SysFileVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface ISysFileService {

    SysFileVo upload(MultipartFile file);
}
