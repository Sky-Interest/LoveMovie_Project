package org.example.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.model.vo.SysUserQueryVo;
import org.example.system.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author dafei
 * @since 2024-09-20
 */
public interface SysUserService extends IService<SysUser> {
    IPage<SysUser> selectPage(IPage<SysUser> iPage, SysUserQueryVo sysUserQueryVo);
    void updateStatus(Long id, Integer status);
    SysUser getUserInfoUserName(String username);
    Map<String, Object> getUserInfo(String username);
}
