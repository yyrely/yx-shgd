package com.yx.shgd.controller.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yx.shgd.model.po.sys.SysUserPo;
import com.yx.shgd.model.vo.page.PagingObject;
import com.yx.shgd.model.vo.page.SimplePagingObject;
import com.yx.shgd.model.vo.sys.SysUserPasswordVo;
import com.yx.shgd.model.vo.sys.SysUserVo;
import com.yx.shgd.service.sys.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author HU
 * @date 2022/1/21 11:56
 */

@Slf4j
@RestController
@RequestMapping("/api/sys/user")
@Api(value = "user", tags = "用户管理模块")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @ApiOperation("保存用户")
    @PostMapping("/save")
    public void save(@Valid @RequestBody SysUserVo sysUserVo) {
        sysUserService.addUser(sysUserVo);
    }

    @ApiOperation("删除用户")
    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        sysUserService.removeUserById(id);
    }

    @ApiOperation("更新用户")
    @PostMapping("/update")
    public void update(@Valid @RequestBody SysUserVo sysUserVo) {
        sysUserService.updateUser(sysUserVo);
    }

    @ApiOperation("更新用户密码")
    @PostMapping("/update/password")
    public void updatePassword(@Valid @RequestBody SysUserPasswordVo sysUserPasswordVo) {
        sysUserService.updatePassword(sysUserPasswordVo);
    }

    @ApiOperation("用户分页列表")
    @GetMapping("/page")
    public PagingObject<SysUserVo> page(Page<SysUserPo> page, SysUserVo sysUserVo) {
        log.info("用户分页列表");
        IPage<SysUserVo> pageUser = sysUserService.pageUser(page, sysUserVo);
        return new SimplePagingObject<>(pageUser.getRecords(), page.getCurrent(), page.getSize(), pageUser.getTotal());
    }

    @ApiOperation("用户详情")
    @GetMapping("/info/{id}")
    public SysUserPo page(@PathVariable("id") Long id) {
        SysUserPo sysUserPo = sysUserService.getById(id);
        sysUserPo.setPassword(null);
        return sysUserPo;
    }

}
