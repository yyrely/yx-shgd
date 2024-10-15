package com.yx.shgd.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yx.shgd.model.po.sys.SysRoleMenuPo;
import com.yx.shgd.model.po.sys.SysRolePo;
import com.yx.shgd.model.vo.sys.SysRoleVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hu
 * @since 2022-01-20
 */
public interface ISysRoleService extends IService<SysRolePo> {

    /**
     * 删除角色
     * @param id
     */
    void removeRoleById(Long id);

    /**
     * 更新角色菜单权限
     * @param sysRoleVo
     */
    void updateRoleMenus(SysRoleVo sysRoleVo);

    /**
     * 根据角色id获取菜单列表
     * @param roleId
     */
    List<SysRoleMenuPo> listMenuIdsByRoleId(Long roleId);


}
