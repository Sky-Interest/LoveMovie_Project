package org.example.system.controller;

import io.swagger.annotations.ApiOperation;
import org.example.model.system.SysMenu;
import org.example.system.service.SysMenuService;
import org.example.system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
