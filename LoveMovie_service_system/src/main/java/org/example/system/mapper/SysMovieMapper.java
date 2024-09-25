package org.example.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.example.model.system.SysMovie;
import org.example.model.vo.SysMovieQueryVo;

public interface SysMovieMapper extends BaseMapper<SysMovie> {
    public IPage<SysMovie> selectPage(IPage<SysMovie> p1, @Param("vo") SysMovieQueryVo sysMovieQueryVo);
}
