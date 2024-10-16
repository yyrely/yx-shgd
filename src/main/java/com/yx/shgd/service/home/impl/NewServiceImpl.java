package com.yx.shgd.service.home.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.shgd.mapper.home.NewMapper;
import com.yx.shgd.mapper.home.ProductMapper;
import com.yx.shgd.model.po.home.NewPo;
import com.yx.shgd.model.po.home.ProductPo;
import com.yx.shgd.service.home.INewService;
import com.yx.shgd.service.home.IProductService;
import org.springframework.stereotype.Service;

@Service
public class NewServiceImpl extends ServiceImpl<NewMapper, NewPo> implements INewService {


}
