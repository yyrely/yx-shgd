package com.yx.shgd.controller.sys;


import cn.hutool.core.bean.BeanUtil;
import com.yx.shgd.model.dto.sys.SysDeptDto;
import com.yx.shgd.model.po.sys.SysDeptPo;
import com.yx.shgd.model.vo.sys.SysDeptVo;
import com.yx.shgd.service.sys.ISysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Hu
 * @since 2022-01-21
 */
@RestController
@RequestMapping("/api/sys/dept")
@Api(value = "dept", tags = "部门管理模块")
public class SysDeptController {

    @Autowired
    private ISysDeptService sysDeptService;

    /**
     * 通过ID查询
     * @param id ID
     * @return SysDept
     */
    @GetMapping("/info/{id}")
    @ApiOperation("通过ID查询部门详情")
    public SysDeptPo getById(@PathVariable Integer id) {
        return sysDeptService.getById(id);
    }

    /**
     * 添加
     * @param sysDeptVo 实体
     */
    @PostMapping("/save")
    @ApiOperation("添加部门")
    public void save(@Valid @RequestBody SysDeptVo sysDeptVo) {
        sysDeptService.saveDept(sysDeptVo);
    }

    /**
     * 删除
     * @param id ID
     */
    @ApiOperation("删除部门")
    @PostMapping("/delete/{id}")
    public void removeById(@PathVariable Integer id) {
        sysDeptService.removeDeptById(id);
    }

    /**
     * 更新
     * @param sysDeptVo sysDeptVo
     */
    @ApiOperation("更新部门")
    @PostMapping("/update")
    public void removeById(@Valid @RequestBody SysDeptVo sysDeptVo) {
        sysDeptService.updateById(BeanUtil.copyProperties(sysDeptVo, SysDeptPo.class));
    }

    /**
     * 获取部门树状结构
     * @return SysDept
     */
    @ApiOperation("获取部门树状结构")
    @GetMapping(value = "/tree")
    public List<SysDeptDto> getTree(boolean lazy, Long parentId) {
        return sysDeptService.treeDept(lazy, parentId);
    }

}

