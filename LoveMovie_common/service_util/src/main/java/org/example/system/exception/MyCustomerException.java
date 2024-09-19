package org.example.system.exception;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.system.SysRole;
import org.example.system.util.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyCustomerException extends RuntimeException {
    private Integer code;
    private String msg;
    //3.执行自定义异常
    @ExceptionHandler(MyCustomerException.class)
    @ResponseBody
    public Result error(MyCustomerException e)
    {
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }
//    @ApiOperation("查询全部接口")
//    @GetMapping("/findAll")
//    public Result findAll()
//    {
//
//        try {
//            int i = 1/0;
//        } catch (Exception e) {
//            // 手动抛出异常
//            throw new MyCustomerException(2001,"自定义异常..");
//        }
//
//        List<SysRole> list = this.sysRoleService.list();
//        return Result.ok(list);
//    }


}
