package edu.nju.desserthouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.MemberDao;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.stavo.MemberMonthStaVO;
import edu.nju.desserthouse.model.stavo.MemberStaVO;
import edu.nju.desserthouse.model.stavo.ShopStaItemVO;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public void save(Member member) {
		try {
			baseDao.save(member);

		}catch (Exception e) {			
			e.printStackTrace();
		}
	}

	@Override
	public Member find(int id) {
		Member member = (Member)baseDao.load(Member.class, id);
		return member;
	}

	@Override
	public void updateByUserid(Member member) {
		baseDao.update(member);
	}

	@Override
	public List<Member> getAllMemberList() {
		@SuppressWarnings("unchecked")
		List<Member> list = baseDao.getAllList(Member.class);
		return list;
	}

	@Override
	public List<MemberMonthStaVO> getmmsList(int level, int month) {
		String sql = "select v1.cid,ifnull(v1.deal,0),ifnull(v1.total,0),ifnull(v2.deal,0),ifnull(v2.total,0),ifnull(ifnull(v1.deal,0)/ifnull(v2.deal,0),0) from  "
				+ "(SELECT m.cid, o1.deal,o1.total  "
				+ "from desserthouse.member m left join  "
				+ "(SELECT o.cid,count(*) as deal,sum(o.realTotal) as total FROM desserthouse.`order` o where o.isValid=1 and MONTH(orderTime)= "+month
				+ " and o.cid!=0 "
				+ "group by o.cid) o1 on o1.cid = m.cid "
				+ "where m.level = "+level
				+ " ) as v1 "
				+ "join  "
				+ "(SELECT m.cid, o1.deal,o1.total  "
				+ "from desserthouse.member m left join  "
				+ "(SELECT o.cid,count(*) as deal,sum(o.realTotal) as total FROM desserthouse.`order` o where o.isValid=1 and MONTH(orderTime)= "+(month-1)
				+ " and o.cid!=0 "
				+ "group by o.cid) o1 on o1.cid = m.cid "
				+ "where m.level = "+level
				+ " ) as v2 "
				+ "on v1.cid = v2.cid";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<MemberMonthStaVO> list = new ArrayList<MemberMonthStaVO>();
		for (Object[] obj : objects) {
			MemberMonthStaVO vo = new MemberMonthStaVO();
			vo.cid = (int) obj[0];
			vo.deal = Integer.parseInt(obj[1].toString());
			
			double num =  (double) obj[2];
			num = (double)Math.round(num*100)/100;
			vo.total = num;
			
			vo.lastDeal = Integer.parseInt(obj[3].toString());
			
			num =  (double) obj[4];
			num = (double)Math.round(num*100)/100;
			vo.lastTotal = num;
			
			num =  Double.parseDouble(obj[5].toString());
			num = (double)Math.round(num*10000)/100;
			vo.percent = num;
			
			list.add(vo);
		}
		return list;
	}

	@Override
	public List<List<MemberStaVO>> getMemberSta() {
		List<List<MemberStaVO>> list = new ArrayList<List<MemberStaVO>>();
		for(int i = 1;i<=3;i++){
			String sql = "select DATE_FORMAT(o.orderTime,'%Y-%m'),count(o.oid),sum(o.realTotal) "
					+ "from `order` o join member m on m.cid = o.cid "
					+ " where m.level = "
					+ i
					+ " group by DATE_FORMAT(o.orderTime,'%Y-%m')";
			List<Object[]> objects = baseDao.querySQL(sql);
			List<MemberStaVO> l = new ArrayList<MemberStaVO>();
			for (Object[] obj : objects) {
				MemberStaVO vo = new MemberStaVO();
				vo.date = (String)obj[0];
				vo.deal =  Integer.parseInt(obj[1].toString());
				double num =  Double.parseDouble(obj[2].toString());
				num = (double)Math.round(num*100)/100;
				vo.total = num;
				l.add(vo);
			}
			list.add(l);
		}
		return list;
	}

}
