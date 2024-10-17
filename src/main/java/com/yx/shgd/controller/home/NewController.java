package com.yx.shgd.controller.home;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yx.shgd.common.config.authorization.AnonymousAccess;
import com.yx.shgd.common.exception.ServiceException;
import com.yx.shgd.model.po.home.NewPo;
import com.yx.shgd.model.vo.home.AdvantageQueryVo;
import com.yx.shgd.model.vo.home.NewQueryVo;
import com.yx.shgd.model.vo.home.NewVo;
import com.yx.shgd.model.vo.page.SimplePagingObject;
import com.yx.shgd.service.home.IFactoryService;
import com.yx.shgd.service.home.INewService;
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
@RequestMapping("/api/home/new")
@Api(value = "new", tags = "新闻管理")
public class NewController {

    @Resource
    private INewService newService;

    /**
     * 通过ID查询
     * @param id ID
     * @return SysDept
     */
    @GetMapping("/info/{id}")
    @ApiOperation("通过ID查询详情")
    public NewVo getById(@PathVariable Integer id) {
        return BeanUtil.copyProperties(newService.getById(id), NewVo.class);
    }

    @PostMapping("/save")
    @ApiOperation("保存")
    public NewVo save(@RequestBody NewVo newVo) {
        newVo.setId(null);
        NewPo newPo = BeanUtil.copyProperties(newVo, NewPo.class);
        newService.save(newPo);
        return BeanUtil.copyProperties(newPo, NewVo.class);
    }

    @PostMapping("/update")
    @ApiOperation("更新")
    public void update(@RequestBody NewVo newVo) {
        if(Objects.isNull(newVo.getId())) {
            throw new ServiceException("参数异常");
        }
        NewPo newPo = BeanUtil.copyProperties(newVo, NewPo.class);
        newService.updateById(newPo);
    }

    @PostMapping("/delete/{id}")
    @ApiOperation("删除")
    public void delete(@PathVariable Long id) {
        if(Objects.isNull(id)) {
            throw new ServiceException("参数异常");
        }
        newService.removeById(id);
    }

    @PostMapping("/page")
    @ApiOperation("分页")
    public SimplePagingObject<NewVo> page(@RequestBody NewQueryVo newQueryVo) {
        IPage<NewPo> page = newService.pageNew(newQueryVo);
        List<NewPo> newPos = page.getRecords();
        List<NewVo> carouselVos = BeanUtil.copyToList(newPos, NewVo.class);
        return new SimplePagingObject<>(carouselVos, page.getCurrent(), page.getSize(), page.getTotal());
    }

    @AnonymousAccess
    @PostMapping("/list")
    @ApiOperation("列表")
    public List<NewVo> list(@RequestBody NewQueryVo newQueryVo) {
        List<NewPo> newPos = newService.listNew(newQueryVo);
        return BeanUtil.copyToList(newPos, NewVo.class);
    }
}

