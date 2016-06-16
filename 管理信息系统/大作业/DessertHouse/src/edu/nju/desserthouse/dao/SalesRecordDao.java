package edu.nju.desserthouse.dao;

import java.util.List;
import edu.nju.desserthouse.model.SalesRecord;

public interface SalesRecordDao {
	/*
	 * 像数据库中插入一条消费记录
	 */
	public void save(SalesRecord salesRecord);
	/*
	 * 根据id查找SalesRecord对象,如果找到则返回这个对象,否则返回null
	 */
	public SalesRecord find(int id);
	/*
	 * 根据id更新SalesRecord表的一条记录
	 */
	public void updateBySalesRecordId(SalesRecord salesRecord);
	/*
	 * 获得所有消费记录
	 */
	public List<SalesRecord> getAllSalesRecordList();
}
