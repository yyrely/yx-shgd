package com.yx.shgd.controller.home;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yx.shgd.common.config.authorization.AnonymousAccess;
import com.yx.shgd.common.exception.ServiceException;
import com.yx.shgd.model.dto.sys.SysDeptDto;
import com.yx.shgd.model.po.home.CarouselPo;
import com.yx.shgd.model.po.sys.SysDeptPo;
import com.yx.shgd.model.vo.home.CarouselQueryVo;
import com.yx.shgd.model.vo.home.CarouselVo;
import com.yx.shgd.model.vo.page.SimplePagingObject;
import com.yx.shgd.model.vo.sys.SysDeptVo;
import com.yx.shgd.service.home.ICarouselService;
import com.yx.shgd.service.sys.ISysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * @author Hu
 * @since 2022-01-21
 */
@RestController
@RequestMapping("/api/home/carousel")
@Api(value = "carouse", tags = "轮播图模块")
public class CarouselController {

    @Resource
    private ICarouselService carouselService;

    /**
     * 通过ID查询
     * @param id ID
     * @return SysDept
     */
    @GetMapping("/info/{id}")
    @ApiOperation("通过ID查询详情")
    public CarouselVo getById(@PathVariable Integer id) {
        return BeanUtil.copyProperties(carouselService.getById(id), CarouselVo.class);
    }

    @PostMapping("/save")
    @ApiOperation("保存")
    public CarouselVo save(@RequestBody CarouselVo carouselVo) {
        carouselVo.setId(null);
        CarouselPo carouselPo = BeanUtil.copyProperties(carouselVo, CarouselPo.class);
        carouselService.save(carouselPo);
        return BeanUtil.copyProperties(carouselPo, CarouselVo.class);
    }

    @PostMapping("/update")
    @ApiOperation("更新")
    public void update(@RequestBody CarouselVo carouselVo) {
        if(Objects.isNull(carouselVo.getId())) {
            throw new ServiceException("参数异常");
        }
        CarouselPo carouselPo = BeanUtil.copyProperties(carouselVo, CarouselPo.class);
        carouselService.updateById(carouselPo);
    }

    @PostMapping("/delete/{id}")
    @ApiOperation("删除")
    public void delete(@PathVariable Long id) {
        if(Objects.isNull(id)) {
            throw new ServiceException("参数异常");
        }
        carouselService.removeById(id);
    }

    @PostMapping("/page")
    @ApiOperation("分页")
    public SimplePagingObject<CarouselVo> page(@RequestBody CarouselQueryVo carouselQueryVo) {
        IPage<CarouselPo> page = carouselService.pageCarousel(carouselQueryVo);
        List<CarouselPo> carouselPos = page.getRecords();
        List<CarouselVo> carouselVos = BeanUtil.copyToList(carouselPos, CarouselVo.class);
        return new SimplePagingObject<>(carouselVos, page.getCurrent(), page.getSize(), page.getTotal());
    }

    @AnonymousAccess
    @PostMapping("/list")
    @ApiOperation("列表")
    public List<CarouselVo> list(@RequestBody CarouselQueryVo carouselQueryVo) {
        List<CarouselPo> carouselPos = carouselService.listCarousel(carouselQueryVo);
        return BeanUtil.copyToList(carouselPos, CarouselVo.class);
    }
}

