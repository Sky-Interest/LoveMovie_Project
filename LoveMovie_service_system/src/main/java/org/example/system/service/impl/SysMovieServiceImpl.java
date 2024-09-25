package org.example.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.system.SysMovie;
import org.example.model.vo.SysMovieQueryVo;
import org.example.system.mapper.SysMovieMapper;
import org.example.system.service.SysMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysMovieServiceImpl extends ServiceImpl<SysMovieMapper, SysMovie> implements SysMovieService {

    @Autowired
    private SysMovieMapper sysMovieMapper;

    @Override
    public IPage<SysMovie> selectPage(IPage<SysMovie> p1, SysMovieQueryVo sysMovieQueryVo) {
        return this.baseMapper.selectPage(p1,sysMovieQueryVo);
    }
}
