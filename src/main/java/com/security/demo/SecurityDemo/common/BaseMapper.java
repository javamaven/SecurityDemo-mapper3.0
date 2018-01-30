package com.security.demo.SecurityDemo.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by ${chenhaijun} on 2018/1/29.
 */
public interface BaseMapper<T> extends Mapper<T>,MySqlMapper<T>{
}
