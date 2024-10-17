package com.yx.shgd.service.home;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yx.shgd.model.po.home.FactoryPo;
import com.yx.shgd.model.po.home.NewPo;
import com.yx.shgd.model.vo.home.NewQueryVo;

import java.util.List;

public interface INewService extends IService<NewPo> {

    IPage<NewPo> pageNew(NewQueryVo newQueryVo);

    List<NewPo> listNew(NewQueryVo newQueryVo);
}
