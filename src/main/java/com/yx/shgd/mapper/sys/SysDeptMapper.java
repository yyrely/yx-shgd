package com.yx.shgd.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.shgd.model.dto.sys.SysDeptDto;
import com.yx.shgd.model.po.sys.SysDeptPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Hu
 * @since 2022-01-21
 */

@Mapper
public interface SysDeptMapper extends BaseMapper<SysDeptPo> {

    List<SysDeptDto> selectByParentId(@Param("parentId") Long parentId);
}
