package com.yx.shgd.controller.home;


import cn.hutool.core.bean.BeanUtil;
import com.yx.shgd.model.dto.sys.SysDeptDto;
import com.yx.shgd.model.po.home.CarouselPo;
import com.yx.shgd.model.po.sys.SysDeptPo;
import com.yx.shgd.model.vo.home.CarouselVo;
import com.yx.shgd.model.vo.sys.SysDeptVo;
import com.yx.shgd.service.home.ICarouselService;
import com.yx.shgd.service.sys.ISysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Hu
 * @since 2022-01-21
 */
@RestController
@RequestMapping("/api/home/carouse")
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
    @ApiOperation("通过ID查询部门详情")
    public CarouselVo getById(@PathVariable Integer id) {
        return BeanUtil.copyProperties(carouselService.getById(id), CarouselVo.class);
    }

}

