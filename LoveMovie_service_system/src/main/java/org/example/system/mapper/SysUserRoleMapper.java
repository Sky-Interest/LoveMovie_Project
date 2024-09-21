package org.example.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.model.system.SysUserRole;
import org.springframework.stereotype.Repository;

@Repository()
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

}
