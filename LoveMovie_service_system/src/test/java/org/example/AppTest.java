package org.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.model.system.SysRole;
import org.example.system.mapper.SysRoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = ServiceApplication.class)
@RunWith(SpringRunner.class)
public class AppTest
{

    @Autowired
    private SysRoleMapper sysRoleMapper;

    // 查询全局数据
    @Test
    public void test1()
    {
        List<SysRole> sysRoles = this.sysRoleMapper.selectList(null);
        sysRoles.forEach(System.out::println);
    }

    // 添加
    @Test
    public void test2()
    {
        SysRole  role = new SysRole();
        role.setRoleName("测试账号");
        role.setRoleCode("testadmin");
        role.setDescription("测试账号");

        int row = this.sysRoleMapper.insert(role);
        System.out.println(row);
    }
    // 修改
    @Test
    public void test3()
    {
        //1.根据id 去查询出这个角色
        SysRole role = this.sysRoleMapper.selectById(1L);

        //2.将查询出的这个角色 设置一个要修改的值
        role.setDescription("admin");

        //3.进行修改
        int row = this.sysRoleMapper.updateById(role);

        System.out.println(row);

    }
    /**
     * application-dev.yml 加入配置
     * 此为默认值，如果你的默认值和默认的一样，则不需要该配置
     * mybatis-plus:
     *   global-config:
     *     db-config:
     *       logic-delete-value: 1
     *       logic-not-delete-value: 0
     */
    @Test
    public void testDeleteById(){
        int result = sysRoleMapper.deleteById(2L);
        System.out.println(result);
    }
    @Test
    public void testAutowired() {
        assertNotNull(sysRoleMapper);  // 检查 sysRoleMapper 是否为 null
    }


    @Test
    public void testDeleteBatchIds() {
        int result = sysRoleMapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(result);
    }
    @Test
    public void testQueryWrapper() {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_code", "dafei");
        List<SysRole> roles = sysRoleMapper.selectList(queryWrapper);
        System.out.println(roles);
    }
}
