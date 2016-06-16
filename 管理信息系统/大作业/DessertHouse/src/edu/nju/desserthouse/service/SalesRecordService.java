package edu.nju.desserthouse.service;

import java.util.List;
import edu.nju.desserthouse.model.SalesRecord;

public interface SalesRecordService {
	/*
	 * 新增一条销售记录
	 */
	public void createSalesRecord(SalesRecord salesRecord);
	/*
	 * 取消订单
	 */
	public void cancelSale(int id);
	/*
	 * 获得所有的销售记录
	 */
	public List<SalesRecord> getAllSalesRecordList();
	/*
	 * 获得某用户的所有销售记录
	 */
	public List<SalesRecord> getAllSalesRecordList(int cid);
	/*
	 * 获得某条销售记录
	 */
	public SalesRecord getSalesRecord(int srid);
}
