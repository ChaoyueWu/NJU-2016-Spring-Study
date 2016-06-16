package edu.nju.desserthouse.action;

import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.DessertAvailableBranchVO;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.SalesRecord;
import edu.nju.desserthouse.model.ShopClerk;
import edu.nju.desserthouse.service.DessertAvaliableService;
import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.service.SalesRecordService;
import edu.nju.desserthouse.service.ShopClerkService;

public class SaleDessertMemberAction extends BaseAction {
	@Autowired
	private DessertAvaliableService dessertAvaliableService;
	private SalesRecordService salesRecordService;
	private ShopClerkService shopClerkService;
	private MemberService memberService;
	private String did;
	private String takeDate;
	private String amount;
	private String daid;
	private String price;
	private String cid;

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

	public ShopClerkService getShopClerkService() {
		return shopClerkService;
	}

	public void setShopClerkService(ShopClerkService shopClerkService) {
		this.shopClerkService = shopClerkService;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
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

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(" did:" + did + " takeDate" + takeDate + " amount:" + amount + " daid:" + daid
				+ " price:" + price+" cid:"+cid);
		//1、获得店员所在的店铺编号
		HttpSession session = request.getSession(true);
		int scid = (int) session.getAttribute("id");
		ShopClerk sc = shopClerkService.findShopClerk(scid);
		int sid = sc.getSid();
		
		int didInt = Integer.valueOf(did);
		Date date = java.sql.Date.valueOf(takeDate);
		int amountInt = Integer.valueOf(amount);
		int daidInt = Integer.valueOf(daid);
		double priceDouble = Double.valueOf(price);	
		int cidInt = Integer.valueOf(cid);
		double total = amountInt * priceDouble;
		
		//获得会员信息 计算实际支付金额
		Member member = memberService.findMemberById(cidInt);
		double realTotal = total *(member.getDiscount()/10.0);
		//2、更改会员积分和账户余额
		member.setCredit(member.getCredit()+realTotal);
		member.setBalance(member.getBalance()-realTotal);
		memberService.updateMember(member);
		
		// 3、available dessert的数量
		dessertAvaliableService.sellAvaliableDessert(daidInt, amountInt);
		// 4、销售表增加对应的销售记录
		SalesRecord salesRecord = new SalesRecord();
		Timestamp salesTime = new Timestamp(System.currentTimeMillis());
		salesRecord.setSid(sid);
		salesRecord.setScid(scid);
		salesRecord.setSalesTime(salesTime);
		salesRecord.setDid(didInt);
		salesRecord.setAmount(amountInt);
		salesRecord.setTotal(total);
		salesRecord.setRealTotal(realTotal);
		salesRecord.setIsOnline(0);//到店购买销售,区别于会员在线订购
		salesRecord.setTakeDate(date);
		salesRecord.setIsValid(1);
		salesRecord.setCid(cidInt);
		String dm = String.valueOf(member.getLevel())+"级会员，享受商品"+String.valueOf(member.getDiscount())+"折优惠";
		salesRecord.setDiscountMessage(dm);
		salesRecordService.createSalesRecord(salesRecord);
		
		//返回销售页面
		DessertAvailableBranchVO dessertAvailableVO = dessertAvaliableService.getBranchSaleDesserts(scid);
		request.setAttribute("dateList", dessertAvailableVO.getDateList());
		request.setAttribute("ddMap", dessertAvailableVO.getDdMap());
		return "saleDessertFD";

	}
}
