package com.yx.shgd.service.home.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.shgd.mapper.home.CarouselMapper;
import com.yx.shgd.mapper.sys.SysDeptRelationMapper;
import com.yx.shgd.model.po.home.CarouselPo;
import com.yx.shgd.model.po.sys.SysDeptRelationPo;
import com.yx.shgd.service.home.ICarouselService;
import com.yx.shgd.service.sys.ISysDeptRelationService;
import org.springframework.stereotype.Service;

@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, CarouselPo> implements ICarouselService {
}
