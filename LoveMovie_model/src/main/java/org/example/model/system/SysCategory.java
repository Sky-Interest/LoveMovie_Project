package org.example.model.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import org.example.model.base.BaseEntity;

import java.io.Serializable;

//栏目
@Data
@TableName("sys_category")
public class SysCategory extends BaseEntity {

    private String name;//栏目名
}
