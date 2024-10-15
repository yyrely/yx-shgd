package com.yx.shgd.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yx.shgd.model.po.sys.SysUserPo;
import com.yx.shgd.model.vo.sys.SysUserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HU
 * @date 2022/1/19 15:53
 */

@Mapper
public interface SysUserMapper extends BaseMapper<SysUserPo> {

    /**
     * 分页查询用户信息
     * @param page
     * @param sysUserVo
     * @param deptIds
     */
    IPage<SysUserVo> pageUser(Page<SysUserPo> page, @Param("userQuery") SysUserVo sysUserVo, @Param("deptIds") List<Long> deptIds);
}
