package edu.nju.desserthouse.action;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.DessertAvailableVO;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.SalesRecord;
import edu.nju.desserthouse.service.DessertAvaliableService;
import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.service.SalesRecordService;

public class BuyDessertAction extends BaseAction {
	@Autowired
	private DessertAvaliableService dessertAvaliableService;
	private MemberService memberService;
	private SalesRecordService salesRecordService;
	private String sid;
	private String did;
	private String takeDate;
	private String amount;
	private String daid;
	private String price;

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

	public SalesRecordService getSalesRecordService() {
		return salesRecordService;
	}

	public void setSalesRecordService(SalesRecordService salesRecordService) {
		this.salesRecordService = salesRecordService;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getTakeDate() {
		return takeDate;
	}

	public void setTakeDate(String takeDate) {
		this.takeDate = takeDate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDaid() {
		return daid;
	}

	public void setDaid(String daid) {
		this.daid = daid;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("sid:" + sid + " did:" + did + " takeDate" + takeDate + " amount:" + amount + " daid:" + daid
				+ " price:" + price);
		// 1、会员的账户余额和积分
		HttpSession session = request.getSession(true);
		int id = (int) session.getAttribute("id");
		Member member = memberService.findMemberById(id);
		int amountInt = Integer.valueOf(amount);
		double priceDouble = Double.valueOf(price);
		double total = amountInt * priceDouble;
		double realTotal = total *(member.getDiscount()/10.0);
		member.setCredit(member.getCredit()+realTotal);
		member.setBalance(member.getBalance()-realTotal);
		memberService.updateMember(member);
		request.setAttribute("member", member);
		// 2、available dessert的数量
		dessertAvaliableService.sellAvaliableDessert(Integer.valueOf(daid), Integer.valueOf(amount));
		// 3、销售表增加对应的销售记录
		SalesRecord salesRecord = new SalesRecord();
		salesRecord.setSid(Integer.valueOf(sid));
		Timestamp salesTime = new Timestamp(System.currentTimeMillis());
		salesRecord.setSalesTime(salesTime);
		salesRecord.setDid(Integer.valueOf(did));
		salesRecord.setAmount(amountInt);
		salesRecord.setTotal(total);
		salesRecord.setRealTotal(realTotal);
		salesRecord.setIsOnline(1);
		Date date = java.sql.Date.valueOf(takeDate);
		salesRecord.setTakeDate(date);
		salesRecord.setIsValid(1);
		salesRecord.setCid(member.getCid());
		String dm = String.valueOf(member.getLevel())+"级会员，享受商品"+String.valueOf(member.getDiscount())+"折优惠";
		
		salesRecord.setDiscountMessage(dm);
		salesRecordService.createSalesRecord(salesRecord);
		

		DessertAvailableVO dessertAvailableVO = dessertAvaliableService.getMemberBuyDesserts();
		request.setAttribute("shops", dessertAvailableVO.getShops());
		request.setAttribute("sdMap", dessertAvailableVO.getSdMap());
		request.setAttribute("sddMap", dessertAvailableVO.getSddMap());
		return "reserveProductHY";

	}
}
