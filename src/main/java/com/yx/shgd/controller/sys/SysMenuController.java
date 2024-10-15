package com.yx.shgd.controller.sys;

import cn.hutool.core.bean.BeanUtil;
import com.yx.shgd.model.dto.sys.SysMenuDto;
import com.yx.shgd.model.po.sys.SysMenuPo;
import com.yx.shgd.model.vo.sys.SysMenuVo;
import com.yx.shgd.service.sys.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Hu
 * @since 2022-01-20
 */
@RestController
@RequestMapping("/api/sys/menu")
@Api(value = "menu", tags = "菜单管理模块")
public class SysMenuController {

    @Autowired
    private ISysMenuService sysMenuService;

    /**
     * 通过ID查询菜单的详细信息
     * @param id 菜单ID
     * @return 菜单详细信息
     */
    @ApiOperation("通过ID查询菜单的详细信息")
    @GetMapping("/info/{id}")
    public SysMenuPo getById(@PathVariable Long id) {
        return sysMenuService.getById(id);
    }

    /**
     * 新增菜单
     * 
     * @param sysMenuVo 菜单信息
     * @return
     */
    @ApiOperation("新增菜单")
    @PostMapping("/save")
    public void save(@Valid @RequestBody SysMenuVo sysMenuVo) {
        sysMenuService.save(BeanUtil.copyProperties(sysMenuVo, SysMenuPo.class));
    }

    /**
     * 删除菜单
     * 
     * @param id id
     * @return
     */
    @ApiOperation("删除菜单")
    @PostMapping("/delete/{id}")
    public void removeById(@PathVariable Integer id) {
        sysMenuService.removeMenuById(id);
    }

    /**
     * 更新菜单
     * 
     * @param sysMenuVo sysMenuVo
     * @return
     */
    @ApiOperation("更新菜单")
    @PostMapping("/update")
    public void update(@Valid @RequestBody SysMenuVo sysMenuVo) {
        sysMenuService.updateById(BeanUtil.copyProperties(sysMenuVo, SysMenuPo.class));
    }

    /**
     * 返回树形菜单集合
     * @param lazy 是否是懒加载
     * @param parentId 父节点ID
     * @return 树形菜单
     */
    @ApiOperation("返回树形菜单集合")
    @GetMapping(value = "/tree")
    public List<SysMenuDto> getTree(boolean lazy, Long parentId) {
        return sysMenuService.treeMenu(lazy, parentId);
    }

}
