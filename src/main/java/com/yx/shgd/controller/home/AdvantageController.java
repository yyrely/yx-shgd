package com.yx.shgd.controller.home;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yx.shgd.common.config.authorization.AnonymousAccess;
import com.yx.shgd.common.exception.ServiceException;
import com.yx.shgd.model.po.home.CarouselPo;
import com.yx.shgd.model.vo.home.CarouselQueryVo;
import com.yx.shgd.model.vo.home.CarouselVo;
import com.yx.shgd.model.vo.page.SimplePagingObject;
import com.yx.shgd.service.home.IAdvantageService;
import com.yx.shgd.service.home.ICarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author Hu
 * @since 2022-01-21
 */
@RestController
@RequestMapping("/api/home/advantage")
@Api(value = "advantage", tags = "优势管理")
public class AdvantageController {

    @Resource
    private IAdvantageService advantageService;


}

