package edu.nju.desserthouse.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.desserthouse.dao.BankDao;
import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.model.Bank;

@Repository
public class BankDaoImpl implements BankDao{

	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public Bank find(int id) {
		Bank bank = (Bank)baseDao.load(Bank.class, id);
		return bank;
	}

	@Override
	public void updateByBankid(Bank bank) {
		baseDao.update(bank);
	}

}
