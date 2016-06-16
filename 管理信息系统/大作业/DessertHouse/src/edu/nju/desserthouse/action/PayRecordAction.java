package edu.nju.desserthouse.action;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import edu.nju.desserthouse.model.PaymentRecord;
import edu.nju.desserthouse.service.PaymentRecordService;

public class PayRecordAction extends BaseAction {
	@Autowired
	private PaymentRecordService paymentRecordService;

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
		List<PaymentRecord> paymentRecordList = paymentRecordService.getAllPaymentRecordList(id);
		request.setAttribute("paymentRecordList", paymentRecordList);
		String type = (String) session.getAttribute("type");
		if(type.equals("HY")){
			return "paymentRecordHY";
		}
		return "login";
		
	}
}
