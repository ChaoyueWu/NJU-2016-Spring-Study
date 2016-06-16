package edu.nju.desserthouse.dao;
import edu.nju.desserthouse.model.Bank;

public interface BankDao {
	
	/*
	 * 根据bcid查找bank对象,如果找到则返回这个对象,否则返回null
	 */
	public Bank find(int id);
	
	
	/*
	 * 根据bcid更新bank表的一条记录
	 */
	public void updateByBankid(Bank bank);
}
