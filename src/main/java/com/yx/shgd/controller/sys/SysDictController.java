package com.yx.shgd.controller.sys;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yx.shgd.common.config.authorization.AnonymousAccess;
import com.yx.shgd.common.exception.ServiceException;

import com.yx.shgd.model.po.sys.SysDictDetailPo;
import com.yx.shgd.model.po.sys.SysDictPo;
import com.yx.shgd.model.vo.home.ProductQueryVo;

import com.yx.shgd.model.vo.page.SimplePagingObject;
import com.yx.shgd.model.vo.sys.SysDictDetailVo;
import com.yx.shgd.model.vo.sys.SysDictQueryVo;
import com.yx.shgd.model.vo.sys.SysDictVo;
import com.yx.shgd.model.vo.sys.SysFileVo;
import com.yx.shgd.service.sys.ISysDictDetailService;
import com.yx.shgd.service.sys.ISysDictService;
import com.yx.shgd.service.sys.ISysFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/sys/dict")
@Api(value = "dict", tags = "字典管理模块")
public class SysDictController {

    @Resource
    private ISysDictService sysDictService;

    @Resource
    private ISysDictDetailService sysDictDetailService;

    /**
     * 通过ID查询
     * @param id ID
     * @return SysDept
     */
    @GetMapping("/info/{id}")
    @ApiOperation("通过ID查询详情")
    public SysDictVo getById(@PathVariable Integer id) {
        return BeanUtil.copyProperties(sysDictService.getById(id), SysDictVo.class);
    }

    @PostMapping("/save")
    @ApiOperation("保存")
    public SysDictVo save(@RequestBody SysDictVo sysDictVo) {
        if(CharSequenceUtil.isEmpty(sysDictVo.getCode())) {
            throw new ServiceException("参数异常");
        }
        SysDictPo one = sysDictService.getOne(Wrappers.lambdaQuery(SysDictPo.class).eq(SysDictPo::getCode, sysDictVo.getCode()));
        if(Objects.nonNull(one)) {
            throw new ServiceException("字典已存在: " + sysDictVo.getCode());
        }
        sysDictVo.setId(null);
        SysDictPo sysDictPo = BeanUtil.copyProperties(sysDictVo, SysDictPo.class);
        sysDictService.save(sysDictPo);
        return BeanUtil.copyProperties(sysDictPo, SysDictVo.class);
    }

    @PostMapping("/update")
    @ApiOperation("更新")
    public void update(@RequestBody SysDictVo sysDictVo) {
        if(Objects.isNull(sysDictVo.getId())) {
            throw new ServiceException("参数异常");
        }
        if(CharSequenceUtil.isEmpty(sysDictVo.getCode())) {
            throw new ServiceException("参数异常");
        }
        SysDictPo one = sysDictService.getOne(Wrappers.lambdaQuery(SysDictPo.class)
                .eq(SysDictPo::getCode, sysDictVo.getCode())
                .ne(SysDictPo::getId, sysDictVo.getId()));
        if(Objects.nonNull(one)) {
            throw new ServiceException("字典已存在: " + sysDictVo.getCode());
        }
        SysDictPo sysDictPo = BeanUtil.copyProperties(sysDictVo, SysDictPo.class);
        sysDictService.updateById(sysDictPo);
    }

    @PostMapping("/delete/{id}")
    @ApiOperation("删除")
    public void delete(@PathVariable Long id) {
        if(Objects.isNull(id)) {
            throw new ServiceException("参数异常");
        }
        sysDictService.removeById(id);
        sysDictDetailService.remove(Wrappers.lambdaQuery(SysDictDetailPo.class).eq(SysDictDetailPo::getDictId, id));
    }

    @AnonymousAccess
    @PostMapping("/page")
    @ApiOperation("分页")
    public SimplePagingObject<SysDictVo> page(@RequestBody SysDictQueryVo sysDictQueryVo) {
        IPage<SysDictPo> page = sysDictService.pageDict(sysDictQueryVo);
        List<SysDictPo> sysDictPos = page.getRecords();
        List<SysDictVo> carouselVos = BeanUtil.copyToList(sysDictPos, SysDictVo.class);
        return new SimplePagingObject<>(carouselVos, page.getCurrent(), page.getSize(), page.getTotal());
    }

    @PostMapping("/detail/save")
    @ApiOperation("保存")
    public SysDictVo save(@RequestBody SysDictDetailVo sysDictDetailVo) {
        if(Objects.isNull(sysDictDetailVo.getDictId())) {
            throw new ServiceException("参数异常");
        }
        if(CharSequenceUtil.isEmpty(sysDictDetailVo.getCode())) {
            throw new ServiceException("参数异常");
        }
        SysDictDetailPo one = sysDictDetailService.getOne(Wrappers.lambdaQuery(SysDictDetailPo.class).eq(SysDictDetailPo::getCode, sysDictDetailVo.getCode()));
        if(Objects.nonNull(one)) {
            throw new ServiceException("字典已存在: " + sysDictDetailVo.getCode());
        }
        sysDictDetailVo.setId(null);
        SysDictDetailPo sysDictDetailPo = BeanUtil.copyProperties(sysDictDetailVo, SysDictDetailPo.class);
        sysDictDetailService.save(sysDictDetailPo);
        return BeanUtil.copyProperties(sysDictDetailPo, SysDictVo.class);
    }

    @PostMapping("/detail/update")
    @ApiOperation("字典详情更新")
    public void update(@RequestBody SysDictDetailVo sysDictDetailVo) {
        if(Objects.isNull(sysDictDetailVo.getId())) {
            throw new ServiceException("参数异常");
        }
        if(CharSequenceUtil.isEmpty(sysDictDetailVo.getCode())) {
            throw new ServiceException("参数异常");
        }
        SysDictDetailPo one = sysDictDetailService.getOne(Wrappers.lambdaQuery(SysDictDetailPo.class)
                .eq(SysDictDetailPo::getCode, sysDictDetailVo.getCode())
                .ne(SysDictDetailPo::getId, sysDictDetailVo.getId()));
        if(Objects.nonNull(one)) {
            throw new ServiceException("字典已存在: " + sysDictDetailVo.getCode());
        }
        SysDictDetailPo sysDictDetailPo = BeanUtil.copyProperties(sysDictDetailVo, SysDictDetailPo.class);
        sysDictDetailService.updateById(sysDictDetailPo);
    }

    @PostMapping("/detail/delete/{id}")
    @ApiOperation("字典详情删除")
    public void deleteDetail(@PathVariable Long id) {
        if(Objects.isNull(id)) {
            throw new ServiceException("参数异常");
        }
        sysDictDetailService.removeById(id);
    }

    @GetMapping("/detail/list")
    @ApiOperation("字典详情列表")
    public List<SysDictDetailVo> listDetail(@RequestParam("dictId") Long dictId) {
        if(Objects.isNull(dictId)) {
            throw new ServiceException("参数异常");
        }
        List<SysDictDetailPo> sysDictDetailPos = sysDictDetailService.list(Wrappers.lambdaQuery(SysDictDetailPo.class).eq(SysDictDetailPo::getDictId, dictId));
        return BeanUtil.copyToList(sysDictDetailPos, SysDictDetailVo.class);
    }

    @GetMapping("/info/code")
    @ApiOperation("根据code获取字典详情")
    public SysDictVo listDetail(@RequestParam("dictCode") String dictCode) {
        if(CharSequenceUtil.isEmpty(dictCode)) {
            throw new ServiceException("参数异常");
        }
        SysDictPo sysDictPo = sysDictService.getOne(Wrappers.lambdaQuery(SysDictPo.class).eq(SysDictPo::getCode, dictCode));
        if(Objects.isNull(sysDictPo)) {
            throw new ServiceException("字典不存在: " + dictCode);
        }
        SysDictVo sysDictVo = BeanUtil.copyProperties(sysDictPo, SysDictVo.class);
        List<SysDictDetailPo> sysDictDetailPos = sysDictDetailService.list(Wrappers.lambdaQuery(SysDictDetailPo.class).eq(SysDictDetailPo::getId, sysDictVo.getId()));
        sysDictVo.setSysDictDetailVoList(BeanUtil.copyToList(sysDictDetailPos, SysDictDetailVo.class));
        return sysDictVo;
    }
}
