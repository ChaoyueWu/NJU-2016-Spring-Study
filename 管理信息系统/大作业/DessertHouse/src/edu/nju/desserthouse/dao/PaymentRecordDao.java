package edu.nju.desserthouse.dao;

import java.util.List;

import edu.nju.desserthouse.model.PaymentRecord;

public interface PaymentRecordDao {
	/*
	 * 像数据库中插入一条缴费记录
	 */
	public void save(PaymentRecord paymentRecord);
	/*
	 * 获得所有缴费记录
	 */
	public List<PaymentRecord> getAllPaymentRecordList();
}
