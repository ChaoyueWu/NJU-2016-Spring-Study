package edu.nju.desserthouse.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import edu.nju.desserthouse.dao.SalesRecordDao;
import edu.nju.desserthouse.model.SalesRecord;
import edu.nju.desserthouse.service.SalesRecordService;

public class SalesRecordServiceImpl implements SalesRecordService{
	@Autowired
	private SalesRecordDao salesRecordDao;
	
	public SalesRecordDao getSalesRecordDao() {
		return salesRecordDao;
	}

	public void setSalesRecordDao(SalesRecordDao salesRecordDao) {
		this.salesRecordDao = salesRecordDao;
	}

	@Override
	public void createSalesRecord(SalesRecord salesRecord) {
		salesRecordDao.save(salesRecord);
	}

	@Override
	public void cancelSale(int id) {
		SalesRecord sr = salesRecordDao.find(id);
		sr.setIsValid(0);
		salesRecordDao.updateBySalesRecordId(sr);
	}

	@Override
	public List<SalesRecord> getAllSalesRecordList() {
		return salesRecordDao.getAllSalesRecordList();
	}

	@Override
	public List<SalesRecord> getAllSalesRecordList(int cid) {
		List<SalesRecord> temp= salesRecordDao.getAllSalesRecordList();
		List<SalesRecord> list = new ArrayList<SalesRecord>();
		for(SalesRecord item:temp){
			if(item.getCid() == cid){
				list.add(item);
			}
		}
		return list;
	}

	@Override
	public SalesRecord getSalesRecord(int srid) {
		return salesRecordDao.find(srid);
	}

}
