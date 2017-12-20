package com.app.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.app.web.entity.Bbs;
import com.app.web.entity.Comment;

@Mapper
public interface BbsDao extends BaseDao<Bbs> {

	int queryWebTotal(Map<String, Object> map);

	List<Bbs> queryWebList(Map<String, Object> map);
	
}
