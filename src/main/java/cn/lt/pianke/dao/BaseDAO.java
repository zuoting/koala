package cn.lt.pianke.dao;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by 刘婷 on 2017/3/28.
 * 通用DAO组件
 */
public interface BaseDAO<T> extends Mapper<T>,MySqlMapper<T> {
}

