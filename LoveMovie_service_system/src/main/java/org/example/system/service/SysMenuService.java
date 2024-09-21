package org.example.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.model.system.SysMenu;

import java.util.List;

public interface SysMenuService extends IService<SysMenu> {

    // 加载菜单列表
    List<SysMenu> findNodes();
}
