package com.yx.shgd.service.home.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.shgd.mapper.home.FactoryMapper;
import com.yx.shgd.mapper.home.ProductMapper;
import com.yx.shgd.model.po.home.FactoryPo;
import com.yx.shgd.model.po.home.ProductPo;
import com.yx.shgd.service.home.IFactoryService;
import com.yx.shgd.service.home.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductPo> implements IProductService {


}
