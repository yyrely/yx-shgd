package com.yx.shgd.service.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yx.shgd.model.po.sys.SysUserPo;
import com.yx.shgd.model.vo.sys.SysUserPasswordVo;
import com.yx.shgd.model.vo.sys.SysUserVo;

/**
 * @author HU
 * @date 2022/1/19 14:56
 */

public interface ISysUserService extends IService<SysUserPo> {

    /**
     * 添加用户
     * @param sysUserVo
     */
    void addUser(SysUserVo sysUserVo);

    /**
     * 删除用户
     * @param id
     */
    void removeUserById(Long id);

    /**
     * 更新用户
     * @param sysUserVo
     */
    void updateUser(SysUserVo sysUserVo);

    /**
     * 分页查询用户列表
     * @param page
     * @param sysUserVo
     */
    IPage<SysUserVo> pageUser(Page<SysUserPo> page, SysUserVo sysUserVo);

    /**
     * 更新用户密码
     * @param sysUserPasswordVo
     */
    void updatePassword(SysUserPasswordVo sysUserPasswordVo);
}
