package com.sist.web.service;
import com.sist.web.dto.MemberDTO;
import com.sist.web.entity.MemberEntity;

public interface MemberService {
	public MemberDTO memberLogin(String id,String pwd);
}
