package com.app.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.app.web.entity.Activity;

@Mapper
public interface ActivityDao extends BaseDao<Activity> {

	Activity queryWebFirst();

	
}
