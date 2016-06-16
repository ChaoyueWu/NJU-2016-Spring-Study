package edu.nju.desserthouse.service;

import java.util.List;

import edu.nju.desserthouse.model.PaymentRecord;

public interface PaymentRecordService {
	/*
	 * 新增一条缴费记录
	 */
	public void createPaymentRecord(PaymentRecord paymentRecord);
	/*
	 * 获得某用户的所有缴费记录
	 */
	public List<PaymentRecord> getAllPaymentRecordList(int cid);
	/*
	 * 获得某所有缴费记录
	 */
	public List<PaymentRecord> getAllPaymentRecordList();
}
