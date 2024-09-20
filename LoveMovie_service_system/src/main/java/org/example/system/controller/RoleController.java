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

@Api(tags = "角色管理接口")
@RestController
@RequestMapping(value = "/admin/system/role")
@CrossOrigin
public class RoleController {
    @Autowired
    //此处使用了其他服务
    private SysRoleService iRoleService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("{page}/{limit}")
    public Result findRoleByPageQuery(
            // @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            //  @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            // @ApiParam(name = "roleQueryVo", value = "查询对象", required = false)
            SysRoleQueryVo roleQueryVo) {
        Page<SysRole> pageParam = new Page<SysRole>(page, limit);
        IPage<SysRole> pageModel = iRoleService.selectPage(pageParam, roleQueryVo);
        return Result.ok(pageModel);
    }
}
