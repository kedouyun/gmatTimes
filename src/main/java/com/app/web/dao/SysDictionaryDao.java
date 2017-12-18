package com.app.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app.web.entity.SysDictionary;

@Mapper
public interface SysDictionaryDao extends BaseDao<SysDictionary> {

	List<SysDictionary> queryByTypeId(int i);
	
}
