package com.yx.shgd.service.home;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yx.shgd.model.po.home.AdvantagePo;
import com.yx.shgd.model.po.home.FactoryPo;
import com.yx.shgd.model.vo.home.AdvantageQueryVo;
import com.yx.shgd.model.vo.home.FactoryQueryVo;

import java.util.List;

public interface IFactoryService extends IService<FactoryPo> {

    FactoryPo get();

    IPage<FactoryPo> pageFactory(FactoryQueryVo factoryQueryVo);
}
