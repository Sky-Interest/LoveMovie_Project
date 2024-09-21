package org.example.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.system.SysMenu;
import org.example.system.exception.MyCustomerException;
import org.example.system.mapper.SysMenuMapper;
import org.example.system.service.SysMenuService;
import org.example.system.utils.MenuHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper,SysMenu> implements SysMenuService {

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
        wrapper.eq("parent_id",id);
        Integer c = baseMapper.selectCount(wrapper);
        Long count = Long.valueOf(c.toString());
        if(count > 0) {
            throw new MyCustomerException(201,"菜单下面还有子菜单,请先删除子菜单！");
        }
        // 删除菜单
        baseMapper.deleteById(id);
    }
}
