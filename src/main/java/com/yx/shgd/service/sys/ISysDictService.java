package com.yx.shgd.service.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yx.shgd.model.po.sys.SysDeptPo;
import com.yx.shgd.model.po.sys.SysDictPo;
import com.yx.shgd.model.po.sys.SysMenuPo;
import com.yx.shgd.model.vo.sys.SysDictQueryVo;
import com.yx.shgd.model.vo.sys.SysFileVo;
import org.springframework.web.multipart.MultipartFile;

public interface ISysDictService extends IService<SysDictPo> {

    IPage<SysDictPo> pageDict(SysDictQueryVo sysDictQueryVo);
}
