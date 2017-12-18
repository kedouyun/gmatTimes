package com.app.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app.web.entity.SysDictionaryType;

@Mapper
public interface SysDictionaryTypeDao extends BaseDao<SysDictionaryType> {

	List<SysDictionaryType> queryTotalAll();
	
}
