package com.nb.spring.member.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nb.spring.member.model.dao.MemberDao;
import com.nb.spring.member.model.vo.Member;
import com.nb.spring.product.model.vo.Product;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public Member loginMember(Map<String, String> param) {
		return dao.loginMember(session, param);
	}

	@Override
	public Member selectMember(String memberNo) {
		return dao.selectMember(session,memberNo);
	}

	@Override
	public List<Product> salesList(String memberNo) {
		return dao.salesList(session,memberNo);
	}
	
	public Member selectMemberNickName(String nickName) {
		
		return dao.selectMemberNickName(session, nickName);
	}

	@Override
	public int insertMember(Member m) {
		
		return dao.insertMember(session, m);
	}

	@Override
	public Member selectMemberNamePhone(Map<String, String> param) {
		
		return dao.selectMemberNamePhone(session,param);
	}

	@Override
	public Member selectMemberPhoneEmail(Map<String, String> param) {
		
		return dao.selectMemberPhoneEmail(session,param);
	}

	@Override
	public int updatePassword(Map<String, String> param) {
		
		return dao.updatePassword(session,param);
	}


	public List<Product> salesWaitSearch(Map param) {
		return dao.salesWaitSearch(session, param);
	}

	@Override
	public List<Product> salesSearch(Map param) {
		return dao.salesSearch(session, param);
	}
	
	

}
