package org.example.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.model.system.SysMenu;
import org.example.model.vo.AssginMenuVo;

import java.util.List;

public interface SysMenuService extends IService<SysMenu> {

    // 加载菜单列表
    List<SysMenu> findNodes();
    // 根据id删除菜单
    void removeMenuById(Long id);

    List<SysMenu> findSysMenuByRoleId(Long roleId);

    void doAssign(AssginMenuVo assginMenuVo);
}
