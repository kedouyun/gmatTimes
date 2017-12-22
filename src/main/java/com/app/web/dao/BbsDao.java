package com.app.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.app.web.entity.Bbs;

@Mapper
public interface BbsDao extends BaseDao<Bbs> {

	int queryWebTotal(Map<String, Object> map);

	List<Bbs> queryWebList(Map<String, Object> map);

	List<Bbs> queryIndexList(Map<String, Object> map);

	int queryIndexTotal(Map<String, Object> map);

	Bbs queryWebById(@Param("id") Long id,@Param("memberId")  Long memberId);
	
}
