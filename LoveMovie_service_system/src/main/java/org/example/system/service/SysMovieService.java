package org.example.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.model.system.SysMovie;
import org.example.model.vo.SysMovieQueryVo;

public interface SysMovieService extends IService<SysMovie> {
    IPage<SysMovie> selectPage(IPage<SysMovie> p1, SysMovieQueryVo sysMovieQueryVo);
}
