package edu.nju.desserthouse.action;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.service.PromotionService;

public class NewPromotionAction extends BaseAction{
	@Autowired
	private PromotionService promotionService;
	private MemberService memberService;
	private int level = -1;
	private int value = 0;
	private int require = 0;
	private String date = "2016-06-16";

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}


	public PromotionService getPromotionService() {
		return promotionService;
	}


	public void setPromotionService(PromotionService promotionService) {
		this.promotionService = promotionService;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public int getRequire() {
		return require;
	}


	public void setRequire(int require) {
		this.require = require;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String execute() throws Exception {
		//System.out.println("here!month:"+month+date);
		//增加促销记录
		if(level>=0){
			promotionService.generatePromotion(level, value, require, date);
			level = -1;
		}
		
		//List<List<MemberMonthStaVO>> mmsList = memberService.getMemberMonthStaVO(month);
		//request.setAttribute("mmsList", mmsList);
		//request.setAttribute("month", month);
		return "newPromotion";
		
	}
}
