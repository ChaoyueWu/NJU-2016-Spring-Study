package edu.nju.desserthouse.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.stavo.MemberStaVO;
import edu.nju.desserthouse.service.MemberService;

public class MemberStaAction extends BaseAction{
	@Autowired
	private MemberService memberService;
	
	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}


	@Override
	public String execute() throws Exception {
		List<List<MemberStaVO>> list = memberService.getMemberSta();
		request.setAttribute("list", list);
		return "memberSta";
		
	}
}
