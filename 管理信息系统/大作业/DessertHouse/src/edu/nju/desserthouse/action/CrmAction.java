package edu.nju.desserthouse.action;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.stavo.MemberMonthStaVO;
import edu.nju.desserthouse.service.MemberService;

public class CrmAction extends BaseAction{
	@Autowired
	private MemberService memberService;
	private int month = 6;

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("crm-month:"+month);
		List<List<MemberMonthStaVO>> mmsList = memberService.getMemberMonthStaVO(month);
		request.setAttribute("mmsList", mmsList);
		request.setAttribute("month", month);
		return "crm";
		
	}
}
