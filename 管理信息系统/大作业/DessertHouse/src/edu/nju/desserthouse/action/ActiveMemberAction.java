package edu.nju.desserthouse.action;

import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Bank;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.PaymentRecord;
import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.service.PaymentRecordService;

/*
 * 凡是缴费都应用此
 */
public class ActiveMemberAction extends BaseAction {
	@Autowired
	private MemberService memberService;
	private PaymentRecordService paymentRecordService;

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

	@Override
	public String execute() throws Exception {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		String bcid = request.getParameter("bcid");
		String money = request.getParameter("money");
		double moneyInt = Integer.valueOf(money);
		// 更新银行账户余额
		Bank bank = memberService.findBankById(Integer.valueOf(bcid));
		bank.setBalance(bank.getBalance() - moneyInt);
		// 更新会员信息
		Member member = memberService.findMemberById(id);
		// 现在会员为激活状态
		member.setState(1);
		// 更新最近缴费时间
		Date currentDate = new Date(System.currentTimeMillis());
		member.setHandleDate(currentDate);
		// 更新账户余额
		member.setBalance(moneyInt + member.getBalance());
		// 更新当前会员级别
		int level = member.getLevel();
		int tempLevel = 0;
		if (moneyInt >= 200 && moneyInt < 400) {
			tempLevel = 1;
		}else if(moneyInt>=400&&moneyInt<800){
			tempLevel = 2;
		}else if(moneyInt >=800){
			tempLevel = 3;
		}
		if(tempLevel > level){
			level = tempLevel;
			member.setLevel(level);
			
			//更新折扣信息
			if(level == 1){
				member.setDiscount(9.5);
			}else if(level == 2){
				member.setDiscount(8.8);
			}else{
				member.setDiscount(8.5);
			}
		}
		member.setBcid(Integer.valueOf(bcid));
		memberService.recharge(member, bank);
		session.setAttribute("member", member);
		// 插入一条缴费记录
		PaymentRecord pr = new PaymentRecord();
		pr.setCid(id);
		Timestamp nowdate = new Timestamp(System.currentTimeMillis());
		pr.setDate(nowdate);
		pr.setBcid(Integer.valueOf(bcid));
		pr.setAmount(moneyInt);
		paymentRecordService.createPaymentRecord(pr);
		
		return "activeMember";
	}
}
