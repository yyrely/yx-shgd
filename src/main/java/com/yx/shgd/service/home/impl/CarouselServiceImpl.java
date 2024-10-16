package com.yx.shgd.service.home.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.shgd.mapper.home.CarouselMapper;
import com.yx.shgd.mapper.sys.SysDeptRelationMapper;
import com.yx.shgd.model.po.home.CarouselPo;
import com.yx.shgd.model.po.sys.SysDeptRelationPo;
import com.yx.shgd.model.vo.home.CarouselQueryVo;
import com.yx.shgd.service.home.ICarouselService;
import com.yx.shgd.service.sys.ISysDeptRelationService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, CarouselPo> implements ICarouselService {

    @Override
    public IPage<CarouselPo> pageCarousel(CarouselQueryVo carouselQueryVo) {
        LambdaQueryWrapper<CarouselPo> queryWrapper = Wrappers.lambdaQuery(CarouselPo.class)
                .eq(Objects.nonNull(carouselQueryVo.getEnable()), CarouselPo::getEnable, carouselQueryVo.getEnable())
                .orderByDesc(CarouselPo::getCreateTime);
        return this.page(new Page<>(carouselQueryVo.getPage(), carouselQueryVo.getSize()), queryWrapper);
    }

    @Override
    public List<CarouselPo> listCarousel(CarouselQueryVo carouselQueryVo) {
        LambdaQueryWrapper<CarouselPo> queryWrapper = Wrappers.lambdaQuery(CarouselPo.class)
                .eq(CarouselPo::getEnable, Boolean.TRUE)
                .orderByAsc(CarouselPo::getSort);
        return this.list(queryWrapper);
    }
}
