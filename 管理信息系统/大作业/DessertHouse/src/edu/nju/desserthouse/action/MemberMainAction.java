package edu.nju.desserthouse.action;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.service.MemberService;

public class MemberMainAction extends BaseAction {
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
		Member member = memberService.findMemberById(Integer.valueOf(id));
		session.setAttribute("member", member);
		if (member.getState() == 0) {
			System.out.println("enter state=0");
			return "unactiveMember";
		}
		Date date = member.getHandleDate();
		Date currentDate = new Date(System.currentTimeMillis());
		System.out.println("date:"+date);
		System.out.println("currentDate:"+currentDate);
		System.out.println((currentDate.getTime() - date.getTime()));
		
		if (date != null) {
			long minus = (currentDate.getTime() - date.getTime()) /(1000 * 60 * 60 * 24);
			minus = minus/365;
			if (minus < 1.0 && minus >= 0.0) {
				member.setState(1);
				session.setAttribute("member", member);
				memberService.updateMember(member);
				return "activeMember";
			} else if (minus >= 1.0 && minus < 2.0) {
				member.setState(2);
				session.setAttribute("member", member);
				memberService.updateMember(member);
				return "suspendedMember";
			} else if (minus >= 2.0 || member.getState() == 3) {
				member.setState(3);
				session.setAttribute("member", member);
				memberService.updateMember(member);
				return "stoppedMember";
			}else{
				return "unactiveMember";
			}
		} else {
			return "unactiveMember";
		}

	}
}
