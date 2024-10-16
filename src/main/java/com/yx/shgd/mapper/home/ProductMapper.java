package com.yx.shgd.mapper.home;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.shgd.model.po.home.FactoryPo;
import com.yx.shgd.model.po.home.ProductPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Hu
 * @since 2022-01-21
 */

@Mapper
public interface ProductMapper extends BaseMapper<ProductPo> {

}
