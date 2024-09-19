package org.example.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.model.system.SysRole;
import org.example.model.vo.SysRoleQueryVo;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    public IPage<SysRole> selectPage(IPage<SysRole> page1, @Param("vo") SysRoleQueryVo roleQueryVo);


}
