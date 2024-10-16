package com.yx.shgd.service.home.impl;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.shgd.mapper.home.AdvantageMapper;
import com.yx.shgd.model.po.home.AdvantagePo;
import com.yx.shgd.model.po.home.CarouselPo;
import com.yx.shgd.model.vo.home.AdvantageQueryVo;
import com.yx.shgd.service.home.IAdvantageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdvantageServiceImpl extends ServiceImpl<AdvantageMapper, AdvantagePo> implements IAdvantageService {


    @Override
    public IPage<AdvantagePo> pageAdvantage(AdvantageQueryVo advantageQueryVo) {
        LambdaQueryWrapper<AdvantagePo> queryWrapper = Wrappers.lambdaQuery(AdvantagePo.class)
                .like(CharSequenceUtil.isNotEmpty(advantageQueryVo.getTitle()), AdvantagePo::getTitle, advantageQueryVo.getTitle())
                .eq(Objects.nonNull(advantageQueryVo.getEnable()), AdvantagePo::getEnable, advantageQueryVo.getEnable())
                .orderByDesc(AdvantagePo::getCreateTime);
        return this.page(new Page<>(advantageQueryVo.getPage(), advantageQueryVo.getSize()), queryWrapper);
    }

    @Override
    public List<AdvantagePo> listAdvantage(AdvantageQueryVo advantageQueryVo) {
        LambdaQueryWrapper<AdvantagePo> queryWrapper = Wrappers.lambdaQuery(AdvantagePo.class)
                .eq(AdvantagePo::getEnable, Boolean.TRUE)
                .orderByAsc(AdvantagePo::getSort);
        return this.list(queryWrapper);
    }
}
