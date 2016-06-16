package edu.nju.desserthouse.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.DessertAvailableVO;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.service.DessertAvaliableService;
import edu.nju.desserthouse.service.MemberService;

public class ReserveProductAction extends BaseAction{
	@Autowired
	private DessertAvaliableService dessertAvaliableService;
	private MemberService memberService;

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public DessertAvaliableService getDessertAvaliableService() {
		return dessertAvaliableService;
	}
	public void setDessertAvaliableService(DessertAvaliableService dessertAvaliableService) {
		this.dessertAvaliableService = dessertAvaliableService;
	}


	@Override
	public String execute() throws Exception {
		HttpSession session = request.getSession(true);
		int id = (int) session.getAttribute("id");
		Member member = memberService.findMemberById(id);
		request.setAttribute("member", member);
		
		DessertAvailableVO dessertAvailableVO = dessertAvaliableService.getMemberBuyDesserts();
		request.setAttribute("shops", dessertAvailableVO.getShops());
		request.setAttribute("sdMap", dessertAvailableVO.getSdMap());
		request.setAttribute("sddMap", dessertAvailableVO.getSddMap());
		return "reserveProductHY";
		
	}
}
