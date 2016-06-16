package edu.nju.desserthouse.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.SalesRecord;
import edu.nju.desserthouse.service.SalesRecordService;

public class ConsumeRecordAction extends BaseAction{
	@Autowired
	private SalesRecordService salesRecordService;

	public SalesRecordService getSalesRecordService() {
		return salesRecordService;
	}

	public void setSalesRecordService(SalesRecordService salesRecordService) {
		this.salesRecordService = salesRecordService;
	}

	@Override
	public String execute() throws Exception {
		HttpSession session = request.getSession(true);
		int id = (int) session.getAttribute("id");
		List<SalesRecord> srList = salesRecordService.getAllSalesRecordList(id);
		request.setAttribute("srList", srList);
		
		return "consumeRecord";
		
	}
}
