package com.yx.shgd.controller.home;


import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yx.shgd.common.config.authorization.AnonymousAccess;
import com.yx.shgd.common.exception.ServiceException;
import com.yx.shgd.model.po.home.ProductPo;
import com.yx.shgd.model.vo.home.ProductExcelVo;
import com.yx.shgd.model.vo.home.ProductQueryVo;
import com.yx.shgd.model.vo.home.ProductVo;
import com.yx.shgd.model.vo.page.SimplePagingObject;
import com.yx.shgd.service.home.INewService;
import com.yx.shgd.service.home.IProductService;
import com.yx.shgd.utils.ProductExcelDataListener;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author Hu
 * @since 2022-01-21
 */
@RestController
@RequestMapping("/api/home/product")
@Api(value = "product", tags = "产品管理")
public class ProductController {

    @Resource
    private IProductService productService;

    /**
     * 通过ID查询
     * @param id ID
     * @return SysDept
     */
    @AnonymousAccess
    @GetMapping("/info/{id}")
    @ApiOperation("通过ID查询详情")
    public ProductVo getById(@PathVariable Integer id) {
        return BeanUtil.copyProperties(productService.getById(id), ProductVo.class);
    }

    @PostMapping("/save")
    @ApiOperation("保存")
    public ProductVo save(@RequestBody ProductVo productVo) {
        productVo.setId(null);
        ProductPo productPo = BeanUtil.copyProperties(productVo, ProductPo.class);
        productService.save(productPo);
        return BeanUtil.copyProperties(productPo, ProductVo.class);
    }

    @PostMapping("/update")
    @ApiOperation("更新")
    public void update(@RequestBody ProductVo productVo) {
        if(Objects.isNull(productVo.getId())) {
            throw new ServiceException("参数异常");
        }
        ProductPo productPo = BeanUtil.copyProperties(productVo, ProductPo.class);
        productService.updateById(productPo);
    }

    @PostMapping("/delete/{id}")
    @ApiOperation("删除")
    public void delete(@PathVariable Long id) {
        if(Objects.isNull(id)) {
            throw new ServiceException("参数异常");
        }
        productService.removeById(id);
    }

    @AnonymousAccess
    @PostMapping("/page")
    @ApiOperation("分页")
    public SimplePagingObject<ProductVo> page(@RequestBody ProductQueryVo productQueryVo) {
        IPage<ProductPo> page = productService.pageProduct(productQueryVo);
        List<ProductPo> productPos = page.getRecords();
        List<ProductVo> carouselVos = BeanUtil.copyToList(productPos, ProductVo.class);
        return new SimplePagingObject<>(carouselVos, page.getCurrent(), page.getSize(), page.getTotal());
    }

    @AnonymousAccess
    @PostMapping("/list")
    @ApiOperation("列表")
    public List<ProductVo> list(@RequestBody ProductQueryVo productQueryVo) {
        List<ProductPo> productPos = productService.listProduct(productQueryVo);
        return BeanUtil.copyToList(productPos, ProductVo.class);
    }

    @PostMapping("/import")
    @ApiOperation("导入")
    public void excelImport(MultipartFile file) throws IOException {
        productService.excelImport(file);
    }
}


































