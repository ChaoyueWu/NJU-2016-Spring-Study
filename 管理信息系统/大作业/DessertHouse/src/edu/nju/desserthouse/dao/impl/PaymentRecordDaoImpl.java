package edu.nju.desserthouse.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.PaymentRecordDao;
import edu.nju.desserthouse.model.PaymentRecord;

@Repository
public class PaymentRecordDaoImpl implements PaymentRecordDao{

	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public void save(PaymentRecord paymentRecord) {
		try {
			baseDao.save(paymentRecord);

		}catch (Exception e) {			
			e.printStackTrace();
		}
	}

	@Override
	public List<PaymentRecord> getAllPaymentRecordList() {
		@SuppressWarnings("unchecked")
		List<PaymentRecord> list = baseDao.getAllList(PaymentRecord.class);
		return list;
	}

}
