package org.example.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.model.system.SysRole;
import org.example.model.vo.SysRoleQueryVo;

public interface SysRoleService extends IService<SysRole> {
    IPage<SysRole> selectPage(IPage<SysRole> page1, SysRoleQueryVo roleQueryVo);

}
