package org.example.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.system.SysRole;
import org.example.model.vo.SysRoleQueryVo;
import org.example.system.mapper.SysRoleMapper;
import org.example.system.service.SysRoleService;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {


    @Override
    public IPage<SysRole> selectPage(IPage<SysRole> page1, SysRoleQueryVo roleQueryVo) {
        IPage<SysRole> iPage =   this.baseMapper.selectPage(page1,roleQueryVo);
        return iPage;
    }
}
