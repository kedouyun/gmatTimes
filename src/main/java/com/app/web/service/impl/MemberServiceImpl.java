package com.app.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

import com.app.common.utils.Md5Util;
import com.app.web.dao.MemberDao;
import com.app.web.entity.Member;
import com.app.web.service.MemberService;
import com.app.web.utils.ExecuteResult;

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

	@Override
	public ExecuteResult<Integer> updatePassword(Member member,String oldpassword, String newpassword, String re_newpassword) {
		ExecuteResult<Integer> result=new ExecuteResult<Integer>();
		if(oldpassword.endsWith(re_newpassword)){
			member = memberDao.queryByUserName(member.getUsername());
			if(member!=null){
				if(member.getPassword().equals(Md5Util.getMD5Code(oldpassword))){
					member.setPassword(Md5Util.getMD5Code(newpassword));
					memberDao.update(member);
					result.setCode("000");
					result.setErrorMessage("修改密码成功");
				}else{
					result.setCode("2001");
					result.setErrorMessage("旧密码不正确");
				}
			}else{
				result.setCode("2002");
				result.setErrorMessage("次用户不存在");
			}
		}else{
			result.setCode("2003");
			result.setErrorMessage("新密码输入不一致");
		}
		
		return result;
	}

	@Override
	public void updatePractice(Member loginMember) {
		 memberDao.updatePractice(loginMember);
	}

	@Override
	public Member queryLastPracticeDate(String nowDate, Long id) {
		return memberDao.queryLastPracticeDate(nowDate,id);
	}
	
}
