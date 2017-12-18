package com.app.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.app.web.entity.Member;

@Mapper
public interface MemberDao extends BaseDao<Member> {

	Member queryByEmail(String email);

	Member queryByMobile(String mobile);
	
}
