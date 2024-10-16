package com.yx.shgd.controller.home;


import com.yx.shgd.service.home.IFactoryService;
import com.yx.shgd.service.home.INewService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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


}

