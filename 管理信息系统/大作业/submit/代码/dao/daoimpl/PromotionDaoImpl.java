package edu.nju.desserthouse.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.PromotionDao;
import edu.nju.desserthouse.model.Promotion;
@Repository
public class PromotionDaoImpl implements PromotionDao{
	@Autowired
	private BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public void save(Promotion promotion) {
		String sql  = "insert into promotion(`name`,`value`,`require`,deadline,memtype) values ("
				+ "'´ú½ðÈ¯' ,"
				+ promotion.getValue()
				+ ","
				+ promotion.getRequire()
				+ ","
				+ "'"
				+ promotion.getDeadline()
				+ "'"
				+ ","
				+ promotion.getMemtype()
				+ ")";
		baseDao.excuteBySQL(sql);
	}

	@Override
	public List<Promotion> getAllPromotionList() {
		@SuppressWarnings("unchecked")
		List<Promotion> list = baseDao.getAllList(Promotion.class);
		return list;
	}

	@Override
	public List<Promotion> findMemPromotion(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

}
