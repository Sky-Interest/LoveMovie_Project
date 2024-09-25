package org.example.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.model.system.SysCategory;
import org.example.model.vo.SysCategoryQueryVo;

public interface SysCategoryService extends IService<SysCategory> {
    IPage<SysCategory> selectPage(IPage<SysCategory> page1, SysCategoryQueryVo categoryQueryVo);
}
