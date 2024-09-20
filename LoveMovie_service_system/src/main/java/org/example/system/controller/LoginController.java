package org.example.system.controller;

import io.swagger.annotations.Api;
import org.example.system.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "登录管理控制器")
@RequestMapping(value = "/admin/system/index")
public class LoginController {


    /**
     *  登录接口
     * @return
     */
    @PostMapping(value = "/login")
    public Result login()
    {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("token","admin-token");
        // 注意此处状态码还需要处理的，我们返回的是200，人家这里是20000
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


}
