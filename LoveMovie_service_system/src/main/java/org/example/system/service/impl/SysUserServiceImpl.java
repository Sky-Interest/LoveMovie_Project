package org.example.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.model.vo.SysUserQueryVo;
import org.example.system.entity.SysUser;
import org.example.system.mapper.SysUserMapper;
import org.example.system.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author dafei
 * @since 2024-09-20
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public IPage<SysUser> selectPage(IPage<SysUser> iPage, SysUserQueryVo sysUserQueryVo) {
        return this.baseMapper.selectPage(iPage, sysUserQueryVo);
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        // 1.查询当前用户
        SysUser sysUser = this.baseMapper.selectById(id);
        // 2.设置状态
        sysUser.setStatus(status);
        // 3.更新
        this.baseMapper.updateById(sysUser);
    }

    @Override
    public SysUser getUserInfoUserName(String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>();
        queryWrapper.eq("username",username);

        SysUser sysUser = this.baseMapper.selectOne(queryWrapper);

        return sysUser;
    }
}
