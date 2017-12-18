package com.app.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.app.web.dao.MemberDao;
import com.app.web.entity.Member;
import com.app.web.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member queryObject(Long id){
		return memberDao.queryObject(id);
	}
	
	@Override
	public List<Member> queryList(Map<String, Object> map){
		return memberDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return memberDao.queryTotal(map);
	}
	
	@Override
	public void save(Member member){
		memberDao.save(member);
	}
	
	@Override
	public void update(Member member){
		memberDao.update(member);
	}
	
	@Override
	public void delete(Long id){
		memberDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		memberDao.deleteBatch(ids);
	}

	@Override
	public Member queryByEmail(String email) {
		return memberDao.queryByEmail(email);
	}

	@Override
	public Member queryByMobile(String mobile) {
		return memberDao.queryByMobile(mobile);
	}
	
}
