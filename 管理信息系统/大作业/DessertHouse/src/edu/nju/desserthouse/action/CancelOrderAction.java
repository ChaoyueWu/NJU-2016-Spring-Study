package edu.nju.desserthouse.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Dessert;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.SalesRecord;
import edu.nju.desserthouse.service.DessertAvaliableService;
import edu.nju.desserthouse.service.DessertService;
import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.service.SalesRecordService;

public class CancelOrderAction extends BaseAction {
	@Autowired
	private SalesRecordService salesRecordService;
	private DessertService dessertService;
	private DessertAvaliableService dessertAvaliableService;
	private MemberService memberService;
	private String srid;

	public SalesRecordService getSalesRecordService() {
		return salesRecordService;
	}

	public void setSalesRecordService(SalesRecordService salesRecordService) {
		this.salesRecordService = salesRecordService;
	}

	public DessertService getDessertService() {
		return dessertService;
	}

	public void setDessertService(DessertService dessertService) {
		this.dessertService = dessertService;
	}

	public DessertAvaliableService getDessertAvaliableService() {
		return dessertAvaliableService;
	}

	public void setDessertAvaliableService(DessertAvaliableService dessertAvaliableService) {
		this.dessertAvaliableService = dessertAvaliableService;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public String getSrid() {
		return srid;
	}

	public void setSrid(String srid) {
		this.srid = srid;
	}

	@Override
	public String execute() throws Exception {
		int sridInt = Integer.valueOf(srid);
		//取消订单 并获得该订单详细信息
		salesRecordService.cancelSale(sridInt);
		SalesRecord sr = salesRecordService.getSalesRecord(sridInt);
		//把对应的可售商品数量加上去
		dessertAvaliableService.modifyDessertAvailableAfterCancel(sr.getSid(), sr.getTakeDate(), sr.getDid(), sr.getAmount());
		//把会员对应的积分去掉 账户余额加上
		Member m = memberService.findMemberById(sr.getCid());
		m.setBalance(m.getBalance()+sr.getRealTotal());
		m.setCredit(m.getCredit()-sr.getRealTotal());
		memberService.updateMember(m);
		
		//绑定商品id和商品信息的hashmap，用于显示
		List<Dessert> dList = dessertService.getAllDessertList();
		HashMap<Integer,Dessert> idMap = new HashMap<Integer,Dessert>();
		for(Dessert d : dList){
			idMap.put(d.getDid(),d);
		}
		request.setAttribute("idMap",idMap );
		HttpSession session = request.getSession(true);
		int id = (int) session.getAttribute("id");
		List<SalesRecord> srList = salesRecordService.getAllSalesRecordList(id);
		request.setAttribute("srList", srList);
		return "myOrderHY";

	}
}
