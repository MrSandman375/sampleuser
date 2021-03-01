package com.renjie.sampleuser.model;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Auther: fan
 * @Date: 2021/3/1
 * @Description:
 */
public interface IBaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
