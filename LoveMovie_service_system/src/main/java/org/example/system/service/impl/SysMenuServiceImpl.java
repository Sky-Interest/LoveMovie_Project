package org.example.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.system.SysMenu;
import org.example.model.system.SysRoleMenu;
import org.example.model.vo.AssginMenuVo;
import org.example.system.exception.MyCustomerException;
import org.example.system.mapper.SysMenuMapper;
import org.example.system.mapper.SysRoleMenuMapper;
import org.example.system.service.SysMenuService;
import org.example.system.utils.MenuHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper,SysMenu> implements SysMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public List<SysMenu> findNodes() {
        //1.获取所有的菜单
        List<SysMenu> menuList = this.baseMapper.selectList(null);
        //2.所有菜单数据转换要求数据格式
        List<SysMenu> bulidTree = MenuHelper.bulidTree(menuList);

        return bulidTree;
    }

    @Override
    public void removeMenuById(Long id) {
        // 查询当前删除菜单下面是否有子菜单 根据id = parentid
        QueryWrapper<SysMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", id);
        Integer c = baseMapper.selectCount(wrapper);
        Long count = Long.valueOf(c.toString());
        if (count > 0) {
            throw new MyCustomerException(201, "菜单下面还有子菜单,请先删除子菜单！");
        }
        // 删除菜单
        baseMapper.deleteById(id);
    }

    @Override
    public List<SysMenu> findSysMenuByRoleId(Long roleId) {
        //获取所有status为1的权限列表
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);
        List<SysMenu> menuList = baseMapper.selectList(queryWrapper);

        //根据角色id获取角色权限
        QueryWrapper<SysRoleMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id", roleId);

        List<SysRoleMenu> roleMenus = sysRoleMenuMapper.selectList(wrapper);

        //获取该角色已分配的所有权限id
        List<Long> roleMenuIds = new ArrayList<>();
        for (SysRoleMenu roleMenu : roleMenus) {
            roleMenuIds.add(roleMenu.getMenuId());
        }
        //遍历所有权限列表
        for (SysMenu sysMenu : menuList) {
            if (roleMenuIds.contains(sysMenu.getId())) {
                //设置该权限已被分配
                sysMenu.setSelect(true);
            } else {
                sysMenu.setSelect(false);
            }
        }
        //将权限列表转换为权限树
        List<SysMenu> sysMenus = MenuHelper.bulidTree(menuList);
        return sysMenus;
    }

    @Override
    public void doAssign(AssginMenuVo assginMenuVo) {
        //删除已分配的权限
        sysRoleMenuMapper.delete(new QueryWrapper<SysRoleMenu>().eq("role_id", assginMenuVo.getRoleId()));
        //遍历所有已选择的权限id
        for (Long menuId : assginMenuVo.getMenuIdList()) {
            if (menuId != null) {
                //创建SysRoleMenu对象
                SysRoleMenu sysRoleMenu = new SysRoleMenu();
                sysRoleMenu.setMenuId(menuId);
                sysRoleMenu.setRoleId(assginMenuVo.getRoleId());
                //添加新权限
                sysRoleMenuMapper.insert(sysRoleMenu);
            }
        }
    }
}
