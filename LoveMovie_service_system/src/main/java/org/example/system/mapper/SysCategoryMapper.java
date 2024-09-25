package org.example.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.example.model.system.SysCategory;
import org.example.model.vo.SysCategoryQueryVo;
import org.springframework.stereotype.Repository;

@Repository
public interface SysCategoryMapper extends BaseMapper<SysCategory> {
    public IPage<SysCategory> selectPage(IPage<SysCategory> p1, @Param("vo") SysCategoryQueryVo sysCategoryQueryVo);
}
