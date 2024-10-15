package com.yx.shgd.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.shgd.model.dto.sys.SysMenuDto;
import com.yx.shgd.model.po.sys.SysMenuPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Hu
 * @since 2022-01-20
 */

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenuPo> {

    /**
     * 根据角色获取菜单
     * @param roles
     * @return
     */
    List<SysMenuDto> findMenuByRoleIds(@Param("roles") List<Long> roles);

    /**
     * 根据父节点获取菜单
     * @param parentId
     * @return
     */
    List<SysMenuDto> selectByParentId(@Param("parentId") Long parentId);
}
