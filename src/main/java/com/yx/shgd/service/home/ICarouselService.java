package com.yx.shgd.service.home;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yx.shgd.model.po.home.CarouselPo;
import com.yx.shgd.model.po.sys.SysDeptRelationPo;
import com.yx.shgd.model.vo.home.CarouselQueryVo;

import java.util.List;

public interface ICarouselService extends IService<CarouselPo> {

    IPage<CarouselPo> pageCarousel(CarouselQueryVo carouselQueryVo);

    List<CarouselPo> listCarousel(CarouselQueryVo carouselQueryVo);
}
