package edu.nju.desserthouse.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.DessertAvailableBranchVO;
import edu.nju.desserthouse.service.DessertAvaliableService;
import edu.nju.desserthouse.service.MemberService;

public class SaleDessertAction extends BaseAction{
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
		DessertAvailableBranchVO dessertAvailableVO = dessertAvaliableService.getBranchSaleDesserts(id);
		request.setAttribute("dateList", dessertAvailableVO.getDateList());
		request.setAttribute("ddMap", dessertAvailableVO.getDdMap());
		return "saleDessertFD";
		
	}
}
