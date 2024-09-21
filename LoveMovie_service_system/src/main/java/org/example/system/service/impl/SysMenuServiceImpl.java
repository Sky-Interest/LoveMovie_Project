package org.example.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.system.SysMenu;
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
}
