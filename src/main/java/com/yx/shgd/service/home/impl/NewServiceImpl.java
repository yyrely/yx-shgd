package com.yx.shgd.service.home.impl;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.shgd.mapper.home.NewMapper;
import com.yx.shgd.mapper.home.ProductMapper;
import com.yx.shgd.model.po.home.AdvantagePo;
import com.yx.shgd.model.po.home.NewPo;
import com.yx.shgd.model.po.home.ProductPo;
import com.yx.shgd.model.vo.home.AdvantageQueryVo;
import com.yx.shgd.model.vo.home.NewQueryVo;
import com.yx.shgd.service.home.INewService;
import com.yx.shgd.service.home.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class NewServiceImpl extends ServiceImpl<NewMapper, NewPo> implements INewService {


    @Override
    public IPage<NewPo> pageNew(NewQueryVo newQueryVo) {
        LambdaQueryWrapper<NewPo> queryWrapper = Wrappers.lambdaQuery(NewPo.class)
                .like(CharSequenceUtil.isNotEmpty(newQueryVo.getTitle()), NewPo::getTitle, newQueryVo.getTitle())
                .eq(Objects.nonNull(newQueryVo.getEnable()), NewPo::getEnable, newQueryVo.getEnable())
                .orderByDesc(NewPo::getCreateTime);
        return this.page(new Page<>(newQueryVo.getPage(), newQueryVo.getSize()), queryWrapper);
    }

    @Override
    public List<NewPo> listNew(NewQueryVo newQueryVo) {
        LambdaQueryWrapper<NewPo> queryWrapper = Wrappers.lambdaQuery(NewPo.class)
                .eq(NewPo::getEnable, Boolean.TRUE)
                .orderByAsc(NewPo::getSort);
        return this.list(queryWrapper);
    }
}
