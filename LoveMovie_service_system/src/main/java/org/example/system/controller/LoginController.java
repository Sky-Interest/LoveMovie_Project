package org.example.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.model.vo.LoginVo;
import org.example.system.entity.SysUser;
import org.example.system.exception.MyCustomerException;
import org.example.system.service.SysUserService;
import org.example.system.util.MD5Helper;
import org.example.system.util.JwtHelper;
import org.example.system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "登录管理控制器")
@RequestMapping(value = "/admin/system/index")
public class LoginController {
    @Autowired
    private SysUserService sysUserService;


    // 登录接口
    @ApiOperation("登录方法")
    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo)
    {
        //1.根据username 查询数据
        SysUser sysUser =  this.sysUserService.getUserInfoUserName(loginVo.getUsername());

        //2.如果查询为空 给出提示
        if (sysUser==null){
            throw  new MyCustomerException(20001,"用户不存在..");
        }

        //3.比较密码  （使用用户输入的密码和数据库密码比较）
        String password = loginVo.getPassword();
        String passwordwithMD5 = MD5Helper.encrypt(password);

        if (!sysUser.getPassword().equals(passwordwithMD5)){
            throw new MyCustomerException(20001,"密码不正确");
        }


        //4.判断用户是否可用
        if (sysUser.getStatus().intValue()==0){
            throw new MyCustomerException(20001,"账号被停用..");
        }
        //5.根据用户userid和username去生成token，再通过map封装后返回
        String token = JwtHelper.createToken(sysUser.getId()+"", sysUser.getUsername());
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("token", token);

        return Result.ok(map);
    }
    /**
     *  获取用户信息
     */
    @GetMapping(value = "/info")
    public Result info()
    {
        Map<String,Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("introduction","I am a super admin");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","admin dafei hello!");
        return Result.ok(map);

    }
    /**
     *  退出登录
     */
    @GetMapping(value = "/logout")
    public Result logout()
    {
        return Result.ok();
    }


}
