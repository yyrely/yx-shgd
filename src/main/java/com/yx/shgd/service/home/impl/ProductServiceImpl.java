package com.yx.shgd.service.home.impl;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.shgd.mapper.home.FactoryMapper;
import com.yx.shgd.mapper.home.ProductMapper;
import com.yx.shgd.model.po.home.AdvantagePo;
import com.yx.shgd.model.po.home.FactoryPo;
import com.yx.shgd.model.po.home.ProductPo;
import com.yx.shgd.model.vo.home.ProductQueryVo;
import com.yx.shgd.service.home.IFactoryService;
import com.yx.shgd.service.home.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductPo> implements IProductService {


    @Override
    public IPage<ProductPo> pageProduct(ProductQueryVo productQueryVo) {
        LambdaQueryWrapper<ProductPo> queryWrapper = Wrappers.lambdaQuery(ProductPo.class)
                .like(CharSequenceUtil.isNotEmpty(productQueryVo.getName()), ProductPo::getName, productQueryVo.getName())
                .like(CharSequenceUtil.isNotEmpty(productQueryVo.getCasNo()), ProductPo::getCasNo, productQueryVo.getCasNo())
                .eq(CharSequenceUtil.isNotEmpty(productQueryVo.getType()), ProductPo::getType, productQueryVo.getType())
                .eq(CharSequenceUtil.isNotEmpty(productQueryVo.getBrand()), ProductPo::getBrand, productQueryVo.getBrand())
                .eq(CharSequenceUtil.isNotEmpty(productQueryVo.getSpecification()), ProductPo::getSpecification, productQueryVo.getSpecification())
                .eq(CharSequenceUtil.isNotEmpty(productQueryVo.getPurity()), ProductPo::getPurity, productQueryVo.getPurity())
                .eq(Objects.nonNull(productQueryVo.getEnable()), ProductPo::getEnable, productQueryVo.getEnable())
                .orderByDesc(ProductPo::getCreateTime);
        return this.page(new Page<>(productQueryVo.getPage(), productQueryVo.getSize()), queryWrapper);
    }

    @Override
    public List<ProductPo> listProduct(ProductQueryVo productQueryVo) {
        LambdaQueryWrapper<ProductPo> queryWrapper = Wrappers.lambdaQuery(ProductPo.class)
                .eq(ProductPo::getEnable, Boolean.TRUE)
                .orderByAsc(ProductPo::getSort);
        return this.list(queryWrapper);
    }
}
