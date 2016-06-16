package edu.nju.desserthouse.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.PaymentRecord;
import edu.nju.desserthouse.model.SalesRecord;
import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.service.PaymentRecordService;
import edu.nju.desserthouse.service.SalesRecordService;

public class MemberManageAction extends BaseAction{
	@Autowired
	private MemberService memberService;
	private PaymentRecordService paymentRecordService;
	private SalesRecordService salesRecordService;

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public PaymentRecordService getPaymentRecordService() {
		return paymentRecordService;
	}

	public void setPaymentRecordService(PaymentRecordService paymentRecordService) {
		this.paymentRecordService = paymentRecordService;
	}

	public SalesRecordService getSalesRecordService() {
		return salesRecordService;
	}

	public void setSalesRecordService(SalesRecordService salesRecordService) {
		this.salesRecordService = salesRecordService;
	}

	@Override
	public String execute() throws Exception {
		List<Member> memberList = memberService.getAllMemberList();
		request.setAttribute("memberList", memberList);
		
		List<PaymentRecord> paymentRecordList = paymentRecordService.getAllPaymentRecordList();
		request.setAttribute("paymentRecordList", paymentRecordList);
		
		List<SalesRecord> salesRecordList = salesRecordService.getAllSalesRecordList();
		request.setAttribute("salesRecordList", salesRecordList);
		
		HttpSession session = request.getSession();
		String type = (String) session.getAttribute("type");
		if(type.equals("ZD")){
			return "memberManageZD";
		}else if(type.equals("FD")){
			return "memberManageFD";
		}
		return "login";
		
	}
}
