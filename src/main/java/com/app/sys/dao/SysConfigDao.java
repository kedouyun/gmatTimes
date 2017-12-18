package com.app.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.app.sys.entity.SysConfig;

@Mapper
public interface SysConfigDao extends BaseDao<SysConfig> {
	
	/**
	 * 根据key，查询SysConfig
	 */
	SysConfig queryObjectByKey(String paramKey);
	
	/**
	 * 根据key，更新value
	 */
	int updateValueByKey(@Param("key") String key, @Param("value") String value);
	
}
