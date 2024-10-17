package com.yx.shgd.service.home.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.shgd.mapper.home.AdvantageMapper;
import com.yx.shgd.mapper.home.FactoryMapper;
import com.yx.shgd.model.po.home.AdvantagePo;
import com.yx.shgd.model.po.home.FactoryPo;
import com.yx.shgd.model.vo.home.FactoryQueryVo;
import com.yx.shgd.service.home.IAdvantageService;
import com.yx.shgd.service.home.IFactoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FactoryServiceImpl extends ServiceImpl<FactoryMapper, FactoryPo> implements IFactoryService {


    @Override
    public FactoryPo get() {
        LambdaQueryWrapper<FactoryPo> queryWrapper = Wrappers.lambdaQuery(FactoryPo.class)
                .eq(FactoryPo::getEnable, Boolean.TRUE)
                .orderByAsc(FactoryPo::getSort);
        List<FactoryPo> factoryPos = this.list(queryWrapper);
        if(CollUtil.isNotEmpty(factoryPos)) {
            return factoryPos.get(0);
        }
        return null;
    }

    @Override
    public IPage<FactoryPo> pageFactory(FactoryQueryVo factoryQueryVo) {
        LambdaQueryWrapper<FactoryPo> queryWrapper = Wrappers.lambdaQuery(FactoryPo.class)
                .like(CharSequenceUtil.isNotEmpty(factoryQueryVo.getName()), FactoryPo::getName, factoryQueryVo.getName())
                .eq(Objects.nonNull(factoryQueryVo.getEnable()), FactoryPo::getEnable, factoryQueryVo.getEnable())
                .orderByDesc(FactoryPo::getCreateTime);
        return this.page(new Page<>(factoryQueryVo.getPage(), factoryQueryVo.getSize()), queryWrapper);
    }
}
