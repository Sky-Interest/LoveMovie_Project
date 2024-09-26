package org.example.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.model.system.SysLoginLog;
import org.example.model.vo.SysLoginLogQueryVo;

public interface SysLoginLogService {
    /**
     *
     * @param username
     * @param status
     * @param ipaddr
     * @param message
     */
    public void recordLoginLog(String username,Integer status,String ipaddr,String message);

    //条件分页查询登录日志
    IPage<SysLoginLog> selectPage(long page, long limit, SysLoginLogQueryVo sysLoginLogQueryVo);

    SysLoginLog getById(Long id);
}
