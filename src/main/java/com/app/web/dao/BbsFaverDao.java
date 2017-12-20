package com.app.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.app.web.entity.BbsFaver;

@Mapper
public interface BbsFaverDao extends BaseDao<BbsFaver> {

	BbsFaver queryExist(BbsFaver bbsFaver);
	
}
