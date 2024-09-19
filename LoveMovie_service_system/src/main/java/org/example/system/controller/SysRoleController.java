package org.example.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.model.system.SysRole;
import org.example.model.vo.SysRoleQueryVo;
import org.example.system.service.SysRoleService;
import org.example.system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色管理控制器")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

// http://localhost:8085/admin/system/sysRole/findAll

    // 查询全部记录
//    @ApiOperation("查询全部接口")
//    @GetMapping("/findAll")
//    public List<SysRole> findAll()
//    {
//        List<SysRole> list = this.sysRoleService.list();
//        return list;
//    }
//
//    // 根据id 去逻辑删除
//    @ApiOperation("逻辑删除接口")
//    @DeleteMapping("/remove/{id}")
//    public boolean removeRole(@PathVariable Long id)
//    {
//        boolean isSuccess = this.sysRoleService.removeById(id);
//        return isSuccess;
//    }
    @ApiOperation("查询全部接口")
    @GetMapping("/findAll")
    public Result findAll()
    {

        List<SysRole> list = this.sysRoleService.list();
        return Result.ok(list);
    }

    // 根据id 去逻辑删除
    @ApiOperation("逻辑删除接口")
    @DeleteMapping("/remove/{id}")
    public Result removeRole(@PathVariable Long id)
    {
        boolean isSuccess = this.sysRoleService.removeById(id);
        if (isSuccess)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }

    // 分页 + 查询
    @ApiOperation("角色分页查询")
    @GetMapping("/{page}/{limit}")
    public Result findRoleByPageQuery(@PathVariable Long page,
                                      @PathVariable Long limit,
                                      SysRoleQueryVo roleQueryVo)
    {
        IPage<SysRole> page1 = new Page<>(page,limit);
        page1 =   this.sysRoleService.selectPage(page1,roleQueryVo);
        return Result.ok(page1);
    }
    // 添加
    @ApiOperation("添加角色")
    @PostMapping("addRole")
    public Result addRole(@RequestBody SysRole sysRole)
    {
        boolean isSuccess = this.sysRoleService.save(sysRole);
        if (isSuccess)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }
}
