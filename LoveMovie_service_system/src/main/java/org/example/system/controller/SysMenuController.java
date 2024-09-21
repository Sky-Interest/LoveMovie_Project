package org.example.system.controller;

import io.swagger.annotations.ApiOperation;
import org.example.model.system.SysMenu;
import org.example.system.service.SysMenuService;
import org.example.system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiOperation("菜单管理控制器")
@RestController
@RequestMapping("/admin/system/sysMenu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    // 加载树形菜单
    @ApiOperation("菜单列表")
    @GetMapping("/findNodes")
    public Result findNodes() {
        List<SysMenu> menuList=  this.sysMenuService.findNodes();
        return Result.ok(menuList);
    }
    // 添加菜单
    @ApiOperation("添加菜单")
    @PostMapping("/addMenu")
    public Result addMenu(@RequestBody SysMenu sysMenu){
        this.sysMenuService.save(sysMenu);
        return Result.ok();
    }
    // 修改菜单
    @ApiOperation("根据id去查询菜单")
    // 根据id去查询菜单
    @GetMapping("/findNodeById/{id}")
    public Result findNodeById(@PathVariable Long id){
        SysMenu sysMenu = this.sysMenuService.getById(id);
        return Result.ok(sysMenu);
    }
}

