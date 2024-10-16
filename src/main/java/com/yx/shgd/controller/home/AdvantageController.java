package com.yx.shgd.controller.home;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yx.shgd.common.config.authorization.AnonymousAccess;
import com.yx.shgd.common.exception.ServiceException;
import com.yx.shgd.model.po.home.AdvantagePo;
import com.yx.shgd.model.po.home.CarouselPo;
import com.yx.shgd.model.vo.home.AdvantageQueryVo;
import com.yx.shgd.model.vo.home.AdvantageVo;
import com.yx.shgd.model.vo.home.CarouselQueryVo;
import com.yx.shgd.model.vo.home.CarouselVo;
import com.yx.shgd.model.vo.page.SimplePagingObject;
import com.yx.shgd.service.home.IAdvantageService;
import com.yx.shgd.service.home.ICarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author Hu
 * @since 2022-01-21
 */
@RestController
@RequestMapping("/api/home/advantage")
@Api(value = "advantage", tags = "优势管理")
public class AdvantageController {

    @Resource
    private IAdvantageService advantageService;

    /**
     * 通过ID查询
     * @param id ID
     * @return SysDept
     */
    @GetMapping("/info/{id}")
    @ApiOperation("通过ID查询详情")
    public AdvantageVo getById(@PathVariable Integer id) {
        return BeanUtil.copyProperties(advantageService.getById(id), AdvantageVo.class);
    }

    @PostMapping("/save")
    @ApiOperation("保存")
    public AdvantageVo save(@RequestBody AdvantageVo advantageVo) {
        advantageVo.setId(null);
        AdvantagePo advantagePo = BeanUtil.copyProperties(advantageVo, AdvantagePo.class);
        advantageService.save(advantagePo);
        return BeanUtil.copyProperties(advantagePo, AdvantageVo.class);
    }

    @PostMapping("/update")
    @ApiOperation("更新")
    public void update(@RequestBody AdvantageVo advantageVo) {
        if(Objects.isNull(advantageVo.getId())) {
            throw new ServiceException("参数异常");
        }
        AdvantagePo advantagePo = BeanUtil.copyProperties(advantageVo, AdvantagePo.class);
        advantageService.updateById(advantagePo);
    }

    @PostMapping("/delete/{id}")
    @ApiOperation("删除")
    public void delete(@PathVariable Long id) {
        if(Objects.isNull(id)) {
            throw new ServiceException("参数异常");
        }
        advantageService.removeById(id);
    }

    @PostMapping("/page")
    @ApiOperation("分页")
    public SimplePagingObject<AdvantageVo> page(@RequestBody AdvantageQueryVo advantageQueryVo) {
        IPage<AdvantagePo> page = advantageService.pageAdvantage(advantageQueryVo);
        List<AdvantagePo> advantagePos = page.getRecords();
        List<AdvantageVo> carouselVos = BeanUtil.copyToList(advantagePos, AdvantageVo.class);
        return new SimplePagingObject<>(carouselVos, page.getCurrent(), page.getSize(), page.getTotal());
    }

    @AnonymousAccess
    @PostMapping("/list")
    @ApiOperation("列表")
    public List<AdvantageVo> list(@RequestBody AdvantageQueryVo advantageQueryVo) {
        List<AdvantagePo> advantagePos = advantageService.listAdvantage(advantageQueryVo);
        return BeanUtil.copyToList(advantagePos, AdvantageVo.class);
    }
}

