package edu.nju.desserthouse.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.SalesRecordDao;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.SalesRecord;

@Repository
public class SalesRecordDaoImpl implements SalesRecordDao{

	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public void save(SalesRecord salesRecord) {
		try {
			baseDao.save(salesRecord);

		}catch (Exception e) {			
			e.printStackTrace();
		}
	}

	@Override
	public void updateBySalesRecordId(SalesRecord salesRecord) {
		baseDao.update(salesRecord);
	}

	@Override
	public List<SalesRecord> getAllSalesRecordList() {
		@SuppressWarnings("unchecked")
		List<SalesRecord> list = baseDao.getAllList(SalesRecord.class);
		return list;
	}

	@Override
	public SalesRecord find(int id) {
		SalesRecord salesRecord = (SalesRecord)baseDao.load(SalesRecord.class, id);
		return salesRecord;
	}

}
