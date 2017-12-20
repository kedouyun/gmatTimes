package com.app.web.service;

import com.app.web.entity.Member;
import com.app.web.utils.ExecuteResult;

import java.util.List;
import java.util.Map;

/**
 * @author liangliang
 * @Description: TODO(前端用户)
 * @date 2017-11-19 21:25:29
 */
public interface MemberService {
	
	Member queryObject(Long id);
	
	List<Member> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Member member);
	
	void update(Member member);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	Member queryByEmail(String content);

	Member queryByMobile(String content);

	ExecuteResult<Integer> updatePassword(Member member, String oldpassword, String newpassword, String re_newpassword);

}
