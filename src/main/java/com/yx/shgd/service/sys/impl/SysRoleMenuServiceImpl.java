package com.yx.shgd.service.sys.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yx.shgd.mapper.sys.SysRoleMenuMapper;
import com.yx.shgd.model.po.sys.SysRoleMenuPo;
import com.yx.shgd.service.sys.ISysRoleMenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HU
 * @date 2022/1/21 11:35
 */

@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenuPo> implements ISysRoleMenuService {

    @Override
    public void updateRoleMenus(Long roleId, List<Long> menuIds) {
        // 删除角色原来的菜单
        baseMapper.delete(Wrappers.<SysRoleMenuPo>query().lambda().eq(SysRoleMenuPo::getRoleId, roleId));
        if (CollUtil.isEmpty(menuIds)) {
            return;
        }

        // 批量插入角色新的菜单
        List<SysRoleMenuPo> roleMenuList = menuIds.stream().map(menuId -> {
            SysRoleMenuPo roleMenu = new SysRoleMenuPo();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            return roleMenu;
        }).collect(Collectors.toList());
        if (!roleMenuList.isEmpty()){
            this.saveBatch(roleMenuList);
        }
    }
}
