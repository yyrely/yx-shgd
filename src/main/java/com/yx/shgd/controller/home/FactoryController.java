package com.yx.shgd.controller.home;


import com.yx.shgd.service.home.IAdvantageService;
import com.yx.shgd.service.home.IFactoryService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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


}

