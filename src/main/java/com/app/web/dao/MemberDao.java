package com.app.web.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.app.web.entity.Member;

@Mapper
public interface MemberDao extends BaseDao<Member> {

	Member queryByEmail(String email);

	Member queryByMobile(String mobile);

	Member queryByUserName(String username);

	void updatePractice(Member loginMember);

	Member queryLastPracticeDate(@Param("nowDate") String nowDate,@Param("id")  Long id);
}
