package com.yx.shgd.controller.home;


import com.yx.shgd.service.home.INewService;
import com.yx.shgd.service.home.IProductService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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


}

