package edu.nju.desserthouse.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.PaymentRecordDao;
import edu.nju.desserthouse.model.PaymentRecord;
import edu.nju.desserthouse.service.PaymentRecordService;

public class PaymentRecordServiceImpl implements PaymentRecordService{

	@Autowired
	private PaymentRecordDao paymentRecordDao;
	
	public PaymentRecordDao getPaymentRecordDao() {
		return paymentRecordDao;
	}

	public void setPaymentRecordDao(PaymentRecordDao paymentRecordDao) {
		this.paymentRecordDao = paymentRecordDao;
	}

	@Override
	public void createPaymentRecord(PaymentRecord paymentRecord) {
		paymentRecordDao.save(paymentRecord);
	}

	@Override
	public List<PaymentRecord> getAllPaymentRecordList(int cid) {
		List<PaymentRecord> temp= paymentRecordDao.getAllPaymentRecordList();
		List<PaymentRecord> list = new ArrayList<PaymentRecord>();
		for(PaymentRecord item:temp){
			if(item.getCid() == cid){
				list.add(item);
			}
		}
		return list;
	}

	@Override
	public List<PaymentRecord> getAllPaymentRecordList() {
		return paymentRecordDao.getAllPaymentRecordList();
	}

}
