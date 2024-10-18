package com.yx.shgd.service.sys.impl;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.shgd.common.exception.ServiceException;
import com.yx.shgd.mapper.sys.SysDictMapper;
import com.yx.shgd.mapper.sys.SysMenuMapper;
import com.yx.shgd.model.po.home.FactoryPo;
import com.yx.shgd.model.po.sys.SysDictPo;
import com.yx.shgd.model.po.sys.SysMenuPo;
import com.yx.shgd.model.vo.sys.SysDictQueryVo;
import com.yx.shgd.model.vo.sys.SysFileVo;
import com.yx.shgd.service.sys.ISysDictService;
import com.yx.shgd.service.sys.ISysFileService;
import com.yx.shgd.service.sys.ISysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDictPo> implements ISysDictService {


    @Override
    public IPage<SysDictPo> pageDict(SysDictQueryVo sysDictQueryVo) {
        LambdaQueryWrapper<SysDictPo> queryWrapper = Wrappers.lambdaQuery(SysDictPo.class)
                .like(CharSequenceUtil.isNotEmpty(sysDictQueryVo.getName()), SysDictPo::getName, sysDictQueryVo.getName())
                .like(CharSequenceUtil.isNotEmpty(sysDictQueryVo.getCode()), SysDictPo::getCode, sysDictQueryVo.getCode())
                .orderByDesc(SysDictPo::getCreateTime);
        return this.page(new Page<>(sysDictQueryVo.getPage(), sysDictQueryVo.getSize()), queryWrapper);
    }
}
