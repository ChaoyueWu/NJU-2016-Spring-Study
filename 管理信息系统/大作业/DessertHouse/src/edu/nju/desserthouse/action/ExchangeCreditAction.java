package edu.nju.desserthouse.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.service.MemberService;

public class ExchangeCreditAction extends BaseAction {
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
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		double credit = Double.valueOf(request.getParameter("credit"));
		Member member = memberService.findMemberById(id);
		member.setCredit(member.getCredit()-credit);
		member.setBalance(member.getBalance()+credit/10.0);
		memberService.updateMember(member);
		session.setAttribute("member", member);
		return "activeMember";
	}
}
