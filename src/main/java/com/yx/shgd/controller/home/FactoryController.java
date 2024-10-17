package com.yx.shgd.controller.home;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yx.shgd.common.config.authorization.AnonymousAccess;
import com.yx.shgd.common.exception.ServiceException;
import com.yx.shgd.model.po.home.FactoryPo;
import com.yx.shgd.model.vo.home.AdvantageQueryVo;
import com.yx.shgd.model.vo.home.FactoryQueryVo;
import com.yx.shgd.model.vo.home.FactoryVo;
import com.yx.shgd.model.vo.page.SimplePagingObject;
import com.yx.shgd.service.home.IFactoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author Hu
 * @since 2022-01-21
 */
@RestController
@RequestMapping("/api/home/factory")
@Api(value = "factory", tags = "工厂管理")
public class FactoryController {

    @Resource
    private IFactoryService factoryService;

    /**
     * 通过ID查询
     * @param id ID
     * @return SysDept
     */
    @GetMapping("/info/{id}")
    @ApiOperation("通过ID查询详情")
    public FactoryVo getById(@PathVariable Integer id) {
        return BeanUtil.copyProperties(factoryService.getById(id), FactoryVo.class);
    }

    @PostMapping("/save")
    @ApiOperation("保存")
    public FactoryVo save(@RequestBody FactoryVo factoryVo) {
        factoryVo.setId(null);
        FactoryPo factoryPo = BeanUtil.copyProperties(factoryVo, FactoryPo.class);
        factoryService.save(factoryPo);
        return BeanUtil.copyProperties(factoryPo, FactoryVo.class);
    }

    @PostMapping("/update")
    @ApiOperation("更新")
    public void update(@RequestBody FactoryVo factoryVo) {
        if(Objects.isNull(factoryVo.getId())) {
            throw new ServiceException("参数异常");
        }
        FactoryPo factoryPo = BeanUtil.copyProperties(factoryVo, FactoryPo.class);
        factoryService.updateById(factoryPo);
    }

    @PostMapping("/delete/{id}")
    @ApiOperation("删除")
    public void delete(@PathVariable Long id) {
        if(Objects.isNull(id)) {
            throw new ServiceException("参数异常");
        }
        factoryService.removeById(id);
    }

    @PostMapping("/page")
    @ApiOperation("分页")
    public SimplePagingObject<FactoryVo> page(@RequestBody FactoryQueryVo factoryQueryVo) {
        IPage<FactoryPo> page = factoryService.pageFactory(factoryQueryVo);
        List<FactoryPo> factoryPos = page.getRecords();
        List<FactoryVo> carouselVos = BeanUtil.copyToList(factoryPos, FactoryVo.class);
        return new SimplePagingObject<>(carouselVos, page.getCurrent(), page.getSize(), page.getTotal());
    }

    @AnonymousAccess
    @PostMapping("/get")
    @ApiOperation("首页获取")
    public FactoryVo get() {
        FactoryPo factoryPo = factoryService.get();
        return BeanUtil.copyProperties(factoryPo, FactoryVo.class);
    }
}

