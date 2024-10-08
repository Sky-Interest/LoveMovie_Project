package org.example.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.model.vo.SysUserQueryVo;
import org.example.model.system.SysUser;
import org.example.system.service.SysUserService;
import org.example.system.util.MD5Helper;
import org.example.system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author dafei
 * @since 2024-09-20
 */
@RestController
@Api(tags = "用户管理控制器")
@RequestMapping("/admin/system/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    // 分页和条件查询
    @ApiOperation("分页和条件查询")
    @GetMapping("/{page}/{limit}")
    public Result selectUserPageByVo(@PathVariable Long page,
                                     @PathVariable Long limit,
                                     SysUserQueryVo sysUserQueryVo) {
        IPage<SysUser> iPage = new Page<>(page, limit);

        iPage = this.sysUserService.selectPage(iPage, sysUserQueryVo);

        return Result.ok(iPage);
    }
    // 添加用户
    @PostMapping("/addUser")
    public Result addUser(@RequestBody SysUser sysUser) {
        // 通过MD5 工具类
        String passwordWithMD5 = MD5Helper.encrypt(sysUser.getPassword());
        // 将加密密码设置给sysUser
        sysUser.setPassword(passwordWithMD5);
        boolean b = this.sysUserService.save(sysUser);
        if (b)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }
    // 根据id 去获取一个用户
    @ApiOperation("根据id 去获取一个用户")
    @GetMapping("/findUserById/{id}")
    public Result findUserById(@PathVariable Long id)
    {
        SysUser sysUser = this.sysUserService.getById(id);
        return Result.ok(sysUser);
    }
    //修改用户
    @ApiOperation("修改用户")
    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody SysUser sysUser)
    {
        boolean b = this.sysUserService.updateById(sysUser);
        if (b)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }
    // 根据id删除用户
    @ApiOperation("根据id删除用户")
    @DeleteMapping("/removeUserById/{id}")
    public Result removeUserById(@PathVariable Long id)
    {
        boolean b = this.sysUserService.removeById(id);
        if (b)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }
    // 批量删除用户
    @ApiOperation("批量删除用户")
    @DeleteMapping("/removeBatchUserByIds")
    public Result removeBatchUserById(@RequestBody List<Long> ids)
    {
        boolean b = this.sysUserService.removeByIds(ids);
        if (b)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }

    // 更改用户状态
    @ApiOperation("更改用户状态")
    @GetMapping("/updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable Long id,
                               @PathVariable Integer status) {
        this.sysUserService.updateStatus(id, status);
        return Result.ok();
    }
}

