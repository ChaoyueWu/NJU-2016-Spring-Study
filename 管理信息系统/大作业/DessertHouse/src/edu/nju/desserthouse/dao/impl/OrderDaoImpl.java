package edu.nju.desserthouse.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.desserthouse.dao.BaseDao;
import edu.nju.desserthouse.dao.OrderDao;
import edu.nju.desserthouse.model.stavo.AutoGeneratingPlanItem;
import edu.nju.desserthouse.model.stavo.CategoryOnlyStaVO;
import edu.nju.desserthouse.model.stavo.CateoryProductStaVO;
import edu.nju.desserthouse.model.stavo.DisProductStaVO;
import edu.nju.desserthouse.model.stavo.DistrictYearRankVO;
import edu.nju.desserthouse.model.stavo.InValidAnalysis;
import edu.nju.desserthouse.model.stavo.ProductSalesStaVO;
import edu.nju.desserthouse.model.stavo.ProductTrendItemVO;
import edu.nju.desserthouse.model.stavo.ShopProductStaVO;
import edu.nju.desserthouse.model.stavo.ShopStaItemVO;
import edu.nju.desserthouse.model.stavo.ShopYearRankItemVO;
import edu.nju.desserthouse.sort.DisProductStaVOSortByAmount;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<ProductSalesStaVO> getProductSalesStaVOList() {

		String sql = "SELECT * FROM desserthouse.sta_item_view";

		List<Object[]> objects = baseDao.querySQL(sql);
		List<ProductSalesStaVO> list = new ArrayList<ProductSalesStaVO>();
		for (Object[] obj : objects) {
			ProductSalesStaVO psvo = new ProductSalesStaVO();
			psvo.sid = (int) obj[0];
			psvo.district = (String) obj[1];
			psvo.shop = (String) obj[2];
			psvo.pid = (int) obj[3];
			psvo.product = (String) obj[4];
			psvo.category = (String) obj[5];
			psvo.amount = Integer.parseInt(obj[6].toString());
			psvo.sum = (double) obj[7];
			list.add(psvo);
		}
		return list;
	}

	@Override
	public List<DisProductStaVO> getTotalDisProductStaVOList() {
		String sql = "SELECT siv.did,siv.name,siv.pcname,sum(siv.amount) as samount,sum(siv.sum)as sum "
				+ "FROM desserthouse.sta_item_view as siv " + "group by siv.did,siv.name,siv.pcname";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<DisProductStaVO> list = new ArrayList<DisProductStaVO>();
		for (Object[] obj : objects) {
			DisProductStaVO tdpvo = new DisProductStaVO();
			tdpvo.pid = (int) obj[0];
			tdpvo.product = (String) obj[1];
			tdpvo.category = (String) obj[2];
			tdpvo.amount = Integer.parseInt(obj[3].toString());
			tdpvo.sum = (double) obj[4];
			list.add(tdpvo);
		}
		return list;
	}

	@Override
	public HashMap<String, List<DisProductStaVO>> getDisProSta() {
		String sql = "SELECT siv.disname,siv.did,siv.name,siv.pcname,sum(amount) as amount,sum(siv.sum)as sum "
				+ "FROM desserthouse.sta_item_view as siv " + "group by siv.disname,siv.did,siv.name,siv.pcname";

		List<Object[]> objects = baseDao.querySQL(sql);
		HashMap<String, List<DisProductStaVO>> m = new HashMap<String, List<DisProductStaVO>>();
		String[] dis = { "玄武区", "秦淮区", "鼓楼区", "建邺区", "雨花台区", "浦口区", "栖霞区", "江宁区" };
		for (String s : dis) {
			List<DisProductStaVO> l = new ArrayList<DisProductStaVO>();
			m.put(s, l);
		}
		String tempDis;
		for (Object[] obj : objects) {
			DisProductStaVO dpsvo = new DisProductStaVO();
			dpsvo.pid = (int) obj[1];
			dpsvo.product = (String) obj[2];
			dpsvo.category = (String) obj[3];
			dpsvo.amount = Integer.parseInt(obj[4].toString());
			dpsvo.sum = (double) obj[5];
			tempDis = (String) obj[0];
			m.get(tempDis).add(dpsvo);
		}
		// Collections.sort(tdpList, new DisProductStaVOSortByAmount());
		for (String s : dis) {
			Collections.sort(m.get(s), new DisProductStaVOSortByAmount());
		}
		return m;
	}

	@Override
	public List<ShopProductStaVO> getShopProductStaVOList() {
		String sql = "SELECT siv.sname,siv.did,siv.name,siv.pcname,sum(amount) as amount,"
				+ "sum(siv.sum)as sum FROM desserthouse.sta_item_view as siv "
				+ "group by siv.sname,siv.did,siv.name,siv.pcname";

		List<Object[]> objects = baseDao.querySQL(sql);
		List<ShopProductStaVO> list = new ArrayList<ShopProductStaVO>();
		for (Object[] obj : objects) {
			ShopProductStaVO spvo = new ShopProductStaVO();
			spvo.shop = (String) obj[0];
			spvo.pid = (int) obj[1];
			spvo.product = (String) obj[2];
			spvo.category = (String) obj[3];
			spvo.amount = Integer.parseInt(obj[4].toString());
			spvo.sum = (double) obj[5];
			list.add(spvo);
		}
		return list;
	}

	@Override
	public List<CategoryOnlyStaVO> getCategoryOnlyStaVOList() {
		// 获得商品分类统计
		String sql = "select  pc.pcid,pc.pcname,sum(od.amount) as amount,sum(od.price*od.amount) as sum "
				+ "from orderdetail od join dessert d on od.did=d.did join productcategory pc on d.pcid = pc.pcid "
				+ "group by pc.pcid,pc.pcname";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<CategoryOnlyStaVO> coList = new ArrayList<CategoryOnlyStaVO>();
		for (Object[] obj : objects) {
			CategoryOnlyStaVO covo = new CategoryOnlyStaVO();
			covo.pcid = (int) obj[0];
			covo.pcname = (String) obj[1];
			covo.amount = Integer.parseInt(obj[2].toString());
			covo.sum = (double) obj[3];
			coList.add(covo);
		}
		return coList;

	}

	@Override
	public List<CateoryProductStaVO> getCateoryProductStaVOList() {
		// 获得商品分类&商品统计
		String sql = "select  pc.pcid,pc.pcname,od.did,d.name,sum(od.amount) as amount,sum(od.price*od.amount) as sum "
				+ "from orderdetail od join dessert d on od.did=d.did join productcategory pc on d.pcid = pc.pcid "
				+ "group by pc.pcid,pc.pcname,od.did,d.name";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<CateoryProductStaVO> cpList = new ArrayList<CateoryProductStaVO>();
		for (Object[] obj : objects) {
			CateoryProductStaVO cpvo = new CateoryProductStaVO();
			cpvo.pcid = (int) obj[0];
			cpvo.pcname = (String) obj[1];
			cpvo.did = (int) obj[2];
			cpvo.dname = (String) obj[3];
			cpvo.amount = Integer.parseInt(obj[4].toString());
			cpvo.sum = (double) obj[5];
			cpList.add(cpvo);
		}
		return cpList;
	}

	@Override
	public List<CategoryOnlyStaVO> getCategoryOnlyStaVOList(int disid) {
		// 获得商品分类统计
		String sql = "select  pc.pcid,pc.pcname,sum(od.amount) as amount,sum(od.price*od.amount) as sum "
				+ "from `order` o join orderdetail od on o.oid = od.oid join dessert d on od.did=d.did join productcategory pc on d.pcid = pc.pcid join shop s on s.sid = o.sid "
				+ "where s.disid = " + disid + " group by pc.pcid,pc.pcname";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<CategoryOnlyStaVO> coList = new ArrayList<CategoryOnlyStaVO>();
		for (Object[] obj : objects) {
			CategoryOnlyStaVO covo = new CategoryOnlyStaVO();
			covo.pcid = (int) obj[0];
			covo.pcname = (String) obj[1];
			covo.amount = Integer.parseInt(obj[2].toString());
			covo.sum = (double) obj[3];
			coList.add(covo);
		}
		return coList;

	}

	@Override
	public List<CateoryProductStaVO> getCateoryProductStaVOList(int disid) {
		// 获得商品分类&商品统计
		String sql = "select  pc.pcid,pc.pcname,od.did,d.name,sum(od.amount) as amount,sum(od.price*od.amount) as sum "
				+ "from `order` o join orderdetail od on o.oid = od.oid join dessert d on od.did=d.did join productcategory pc on d.pcid = pc.pcid join shop s on s.sid = o.sid "
				+ "where s.disid = " + disid + " group by pc.pcid,pc.pcname,od.did,d.name";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<CateoryProductStaVO> cpList = new ArrayList<CateoryProductStaVO>();
		for (Object[] obj : objects) {
			CateoryProductStaVO cpvo = new CateoryProductStaVO();
			cpvo.pcid = (int) obj[0];
			cpvo.pcname = (String) obj[1];
			cpvo.did = (int) obj[2];
			cpvo.dname = (String) obj[3];
			cpvo.amount = Integer.parseInt(obj[4].toString());
			cpvo.sum = (double) obj[5];
			cpList.add(cpvo);
		}
		return cpList;
	}

	@Override
	public List<CategoryOnlyStaVO> getCategoryOnlyStaVOList(int disid, int sid) {
		// 获得商品分类统计
		String sql = "select  pc.pcid,pc.pcname,sum(od.amount) as amount,sum(od.price*od.amount) as sum "
				+ "from `order` o join orderdetail od on o.oid = od.oid join dessert d on od.did=d.did join productcategory pc on d.pcid = pc.pcid "
				+ "where o.sid = " + sid + " group by pc.pcid,pc.pcname";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<CategoryOnlyStaVO> coList = new ArrayList<CategoryOnlyStaVO>();
		for (Object[] obj : objects) {
			CategoryOnlyStaVO covo = new CategoryOnlyStaVO();
			covo.pcid = (int) obj[0];
			covo.pcname = (String) obj[1];
			covo.amount = Integer.parseInt(obj[2].toString());
			covo.sum = (double) obj[3];
			coList.add(covo);
		}
		return coList;

	}

	@Override
	public List<CateoryProductStaVO> getCateoryProductStaVOList(int disid, int sid) {
		// 获得商品分类&商品统计
		String sql = "select  pc.pcid,pc.pcname,od.did,d.name,sum(od.amount) as amount,sum(od.price*od.amount) as sum "
				+ "from `order` o join orderdetail od on o.oid = od.oid join dessert d on od.did=d.did join productcategory pc on d.pcid = pc.pcid "
				+ "where o.sid = "+sid
				+ " group by pc.pcid,pc.pcname,od.did,d.name";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<CateoryProductStaVO> cpList = new ArrayList<CateoryProductStaVO>();
		for (Object[] obj : objects) {
			CateoryProductStaVO cpvo = new CateoryProductStaVO();
			cpvo.pcid = (int) obj[0];
			cpvo.pcname = (String) obj[1];
			cpvo.did = (int) obj[2];
			cpvo.dname = (String) obj[3];
			cpvo.amount = Integer.parseInt(obj[4].toString());
			cpvo.sum = (double) obj[5];
			cpList.add(cpvo);
		}
		return cpList;
	}

	@Override
	public List<ShopStaItemVO> getDayShopStaItemVOList() {
		String sql = "select * from day_total_sale_view m left join day_notmember_sale_view nm on m.date1=nm.date2";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<ShopStaItemVO> ssiList = new ArrayList<ShopStaItemVO>();
		for (Object[] obj : objects) {
			ShopStaItemVO ssivo = new ShopStaItemVO();
			ssivo.date = (String) obj[0];
			ssivo.onlineDeal = Integer.parseInt(obj[1].toString());
			ssivo.totalDeal = Integer.parseInt(obj[2].toString());
			ssivo.total = (double) obj[3];
			ssivo.realTotal = Double.valueOf((String)obj[4]);
			if(obj[6]!=null){
				ssivo.notMemberDeal = Integer.parseInt(obj[6].toString());
				ssivo.notMemberSum = (double)obj[7];
			}
			
			ssiList.add(ssivo);
		}
		return ssiList;
	}

	@Override
	public List<ShopStaItemVO> getDayShopStaItemVOList(int disid) {
		String sql = "select * from "
				+ "(SELECT DATE_FORMAT(orderTime,'%Y-%m-%d') as date1, sum(isOnline) as onlineDeal,count(isOnline)as totalDeal,sum(total) as total, "
				+ "format(sum(realTotal),2)as realTatol "
				+ "FROM desserthouse.`order` o join shop s on o.sid = s.sid "
				+ "where isValid = 1 and s.disid = "+disid
				+ " group by DATE_FORMAT(orderTime,'%Y-%m-%d')) as m  "
				+ "left join "
				+ "(SELECT DATE_FORMAT(orderTime,'%Y-%m-%d') as date2, count(isOnline)as notMemberDeal,sum(total) as notMemberSum "
				+ "FROM desserthouse.`order` o join shop s on o.sid = s.sid "
				+ "where isValid = 1 and cid=0 and s.disid = "+disid
				+ " group by DATE_FORMAT(orderTime,'%Y-%m-%d')) as nm  "
				+ "on m.date1=nm.date2";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<ShopStaItemVO> ssiList = new ArrayList<ShopStaItemVO>();
		for (Object[] obj : objects) {
			ShopStaItemVO ssivo = new ShopStaItemVO();
			ssivo.date = (String) obj[0];
			ssivo.onlineDeal = Integer.parseInt(obj[1].toString());
			ssivo.totalDeal = Integer.parseInt(obj[2].toString());
			ssivo.total = (double) obj[3];
			ssivo.realTotal = Double.valueOf((String)obj[4]);
			if(obj[6]!=null){
				ssivo.notMemberDeal = Integer.parseInt(obj[6].toString());
				ssivo.notMemberSum = (double)obj[7];
			}
			ssiList.add(ssivo);
		}
		return ssiList;
	}

	@Override
	public List<ShopStaItemVO> getDayShopStaItemVOList(int disid, int sid) {
		String sql = "select * from "
				+ "(SELECT DATE_FORMAT(orderTime,'%Y-%m-%d') as date1, sum(isOnline) as onlineDeal,count(isOnline)as totalDeal,sum(total) as total, "
				+ "format(sum(realTotal),2)as realTatol "
				+ "FROM desserthouse.`order` o "
				+ "where isValid = 1 and o.sid = "+sid
				+ " group by DATE_FORMAT(orderTime,'%Y-%m-%d')) as m  "
				+ "left join "
				+ "(SELECT DATE_FORMAT(orderTime,'%Y-%m-%d') as date2, count(isOnline)as notMemberDeal,sum(total) as notMemberSum "
				+ "FROM desserthouse.`order` o "
				+ "where isValid = 1 and cid=0 and o.sid = "+sid
				+ " group by DATE_FORMAT(orderTime,'%Y-%m-%d')) as nm  "
				+ "on m.date1=nm.date2";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<ShopStaItemVO> ssiList = new ArrayList<ShopStaItemVO>();
		for (Object[] obj : objects) {
			ShopStaItemVO ssivo = new ShopStaItemVO();
			ssivo.date = (String) obj[0];
			ssivo.onlineDeal = Integer.parseInt(obj[1].toString());
			ssivo.totalDeal = Integer.parseInt(obj[2].toString());
			ssivo.total = (double) obj[3];
			ssivo.realTotal = Double.valueOf((String)obj[4]);
			if(obj[6]!=null){
				ssivo.notMemberDeal = Integer.parseInt(obj[6].toString());
				ssivo.notMemberSum = (double)obj[7];
			}
			ssiList.add(ssivo);
		}
		return ssiList;
	}

	@Override
	public List<ShopStaItemVO> getMonthShopStaItemVOList() {
		String sql = "select * from  "
				+ "(SELECT DATE_FORMAT(orderTime,'%Y-%m') as date1, sum(isOnline) as onlineDeal,count(isOnline)as totalDeal,sum(total) as total, "
				+ "format(sum(realTotal),2)as realTatol "
				+ "FROM desserthouse.`order` o  "
				+ "where isValid = 1 "
				+ "group by DATE_FORMAT(orderTime,'%Y-%m')) as m  "
				+ "left join  "
				+ "(SELECT DATE_FORMAT(orderTime,'%Y-%m') as date2, count(isOnline)as notMemberDeal,sum(total) as notMemberSum "
				+ "FROM desserthouse.`order` o "
				+ "where isValid = 1 and cid=0  "
				+ "group by DATE_FORMAT(orderTime,'%Y-%m')) as nm  "
				+ "on m.date1=nm.date2";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<ShopStaItemVO> ssiList = new ArrayList<ShopStaItemVO>();
		for (Object[] obj : objects) {
			ShopStaItemVO ssivo = new ShopStaItemVO();
			ssivo.date = (String) obj[0];
			ssivo.onlineDeal = Integer.parseInt(obj[1].toString());
			ssivo.totalDeal = Integer.parseInt(obj[2].toString());
			ssivo.total = (double) obj[3];
			ssivo.realTotal = Double.valueOf((String)obj[4]);
			if(obj[6]!=null){
				ssivo.notMemberDeal = Integer.parseInt(obj[6].toString());
				ssivo.notMemberSum = (double)obj[7];
			}
			ssiList.add(ssivo);
		}
		return ssiList;
	}

	@Override
	public List<ShopStaItemVO> getMonthShopStaItemVOList(int disid) {
		String sql = "select * from  "
				+ "(SELECT DATE_FORMAT(orderTime,'%Y-%m') as date1, sum(isOnline) as onlineDeal,count(isOnline)as totalDeal,sum(total) as total, "
				+ "format(sum(realTotal),2)as realTatol "
				+ "FROM desserthouse.`order` o join shop s on s.sid = o.sid "
				+ "where isValid = 1 and s.disid = "+disid
				+ " group by DATE_FORMAT(orderTime,'%Y-%m')) as m  "
				+ "left join  "
				+ "(SELECT DATE_FORMAT(orderTime,'%Y-%m') as date2, count(isOnline)as notMemberDeal,sum(total) as notMemberSum "
				+ "FROM desserthouse.`order` o join shop s on s.sid = o.sid "
				+ "where isValid = 1 and cid=0 and s.disid = "+disid
				+ " group by DATE_FORMAT(orderTime,'%Y-%m')) as nm  "
				+ "on m.date1=nm.date2";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<ShopStaItemVO> ssiList = new ArrayList<ShopStaItemVO>();
		for (Object[] obj : objects) {
			ShopStaItemVO ssivo = new ShopStaItemVO();
			ssivo.date = (String) obj[0];
			ssivo.onlineDeal = Integer.parseInt(obj[1].toString());
			ssivo.totalDeal = Integer.parseInt(obj[2].toString());
			ssivo.total = (double) obj[3];
			ssivo.realTotal = Double.valueOf((String)obj[4]);
			if(obj[6]!=null){
				ssivo.notMemberDeal = Integer.parseInt(obj[6].toString());
				ssivo.notMemberSum = (double)obj[7];
			}
			ssiList.add(ssivo);
		}
		return ssiList;
	}

	@Override
	public List<ShopStaItemVO> getMonthShopStaItemVOList(int disid, int sid) {
		String sql = "select * from  "
				+ "(SELECT DATE_FORMAT(orderTime,'%Y-%m') as date1, sum(isOnline) as onlineDeal,count(isOnline)as totalDeal,sum(total) as total, "
				+ "format(sum(realTotal),2)as realTatol "
				+ "FROM desserthouse.`order` o "
				+ "where isValid = 1 and o.sid = "+sid
				+ " group by DATE_FORMAT(orderTime,'%Y-%m')) as m  "
				+ "left join  "
				+ "(SELECT DATE_FORMAT(orderTime,'%Y-%m') as date2, count(isOnline)as notMemberDeal,sum(total) as notMemberSum "
				+ "FROM desserthouse.`order` o "
				+ "where isValid = 1 and cid=0 and o.sid = "+sid
				+ " group by DATE_FORMAT(orderTime,'%Y-%m')) as nm  "
				+ "on m.date1=nm.date2";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<ShopStaItemVO> ssiList = new ArrayList<ShopStaItemVO>();
		for (Object[] obj : objects) {
			ShopStaItemVO ssivo = new ShopStaItemVO();
			ssivo.date = (String) obj[0];
			ssivo.onlineDeal = Integer.parseInt(obj[1].toString());
			ssivo.totalDeal = Integer.parseInt(obj[2].toString());
			ssivo.total = (double) obj[3];
			ssivo.realTotal = Double.valueOf((String)obj[4]);
			if(obj[6]!=null){
				ssivo.notMemberDeal = Integer.parseInt(obj[6].toString());
				ssivo.notMemberSum = (double)obj[7];
			}
			ssiList.add(ssivo);
		}
		return ssiList;
	}

	@Override
	public List<ProductTrendItemVO> getProductTrendItemVOList(int did) {
		String sql = "select  DATE_FORMAT(orderTime,'%Y-%m-%d') as date,sum(amount) as amount,format(sum(realTotal),2) as total "
				+ "from desserthouse.`order` as o join orderdetail as od on o.oid = od.oid "
				+ "where o.isValid = 1 and od.did = "+did
				+ " group by DATE_FORMAT(orderTime,'%Y-%m-%d')";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<ProductTrendItemVO> ptiList = new ArrayList<ProductTrendItemVO>();
		for (Object[] obj : objects) {
			ProductTrendItemVO ssivo = new ProductTrendItemVO();
			ssivo.date = (String) obj[0];
			ssivo.amount = Integer.parseInt(obj[1].toString());
			ssivo.total = Double.valueOf((String)obj[2]);
			ptiList.add(ssivo);
		}
		return ptiList;
	}

	@Override
	public List<ProductTrendItemVO> getProductTrendItemVOList(int did, int disid) {
		String sql = "select  DATE_FORMAT(orderTime,'%Y-%m-%d') as date,sum(amount) as amount,format(sum(realTotal),2) as total "
				+ "from desserthouse.`order` as o join orderdetail as od on o.oid = od.oid join shop s on s.sid = o.sid "
				+ "where  o.isValid = 1 and od.did = "+did+" and s.disid =  "+disid
				+ " group by DATE_FORMAT(orderTime,'%Y-%m-%d')";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<ProductTrendItemVO> ptiList = new ArrayList<ProductTrendItemVO>();
		for (Object[] obj : objects) {
			ProductTrendItemVO ssivo = new ProductTrendItemVO();
			ssivo.date = (String) obj[0];
			ssivo.amount = Integer.parseInt(obj[1].toString());
			ssivo.total = Double.valueOf((String)obj[2]);
			ptiList.add(ssivo);
		}
		return ptiList;
	}

	@Override
	public List<ProductTrendItemVO> getProductTrendItemVOList(int did, int disid, int sid) {
		String sql = "select  DATE_FORMAT(orderTime,'%Y-%m-%d') as date,sum(amount) as amount,format(sum(realTotal),2) as total "
				+ "from desserthouse.`order` as o join orderdetail as od on o.oid = od.oid  "
				+ "where od.did = "+did+" and o.isValid = 1 and o.sid = "+sid
				+ " group by DATE_FORMAT(orderTime,'%Y-%m-%d')";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<ProductTrendItemVO> ptiList = new ArrayList<ProductTrendItemVO>();
		for (Object[] obj : objects) {
			ProductTrendItemVO ssivo = new ProductTrendItemVO();
			ssivo.date = (String) obj[0];
			ssivo.amount = Integer.parseInt(obj[1].toString());
			ssivo.total = Double.valueOf((String)obj[2]);
			ptiList.add(ssivo);
		}
		return ptiList;
	}

	@Override
	public InValidAnalysis getInvalidOrderAnalysis() {
		String sql = "SELECT count(*),sum(o.realTotal) FROM desserthouse.`order` o where o.isValid = 0";
		List<Object[]> objects = baseDao.querySQL(sql);
		int invalidDeal = Integer.parseInt(objects.get(0)[0].toString());
		double invalidSum = Double.parseDouble(objects.get(0)[1].toString());
		sql = "SELECT count(*),sum(o.realTotal) FROM desserthouse.`order` o ";
		objects = baseDao.querySQL(sql);
		int deal = Integer.parseInt(objects.get(0)[0].toString());
		double num =  invalidDeal/(double)deal;
		num = (double)Math.round(num*10000)/100;
		invalidSum = (double)Math.round(invalidSum);
		InValidAnalysis ia = new InValidAnalysis();
		invalidSum = (double)Math.round(invalidSum);
		ia.invalidDeal = invalidDeal;
		ia.percent = num;
		ia.invalidSum = invalidSum;
		//analysis = "共有"+invalidDeal+"笔订单被取消，"+"占总订单的"+num+"%,如果挽回这些被取消的订单，则可以挽回"+invalidSum+"元。";
		return ia;
	}

	@Override
	public InValidAnalysis getInvalidOrderAnalysis(int disid) {
		String sql = "SELECT count(*),sum(o.realTotal) FROM desserthouse.`order` o join shop s on o.sid = s.sid "
				+ "where o.isValid = 0 and s.disid = "+disid;
		List<Object[]> objects = baseDao.querySQL(sql);
		int invalidDeal = Integer.parseInt(objects.get(0)[0].toString());
		double invalidSum = Double.parseDouble(objects.get(0)[1].toString());
		sql = "SELECT count(*),sum(o.realTotal) FROM desserthouse.`order` o join shop s on o.sid = s.sid "
				+ "where s.disid = "+disid;
		objects = baseDao.querySQL(sql);
		int deal = Integer.parseInt(objects.get(0)[0].toString());
		double num =  invalidDeal/(double)deal;
		num = (double)Math.round(num*10000)/100;
		invalidSum = (double)Math.round(invalidSum);
		InValidAnalysis ia = new InValidAnalysis();
		invalidSum = (double)Math.round(invalidSum);
		ia.invalidDeal = invalidDeal;
		ia.percent = num;
		ia.invalidSum = invalidSum;
		//analysis = "共有"+invalidDeal+"笔订单被取消，"+"占总订单的"+num+"%,如果挽回这些被取消的订单，则可以挽回"+invalidSum+"元。";
		return ia;
	}

	@Override
	public InValidAnalysis getInvalidOrderAnalysis(int disid, int sid) {
		
		
		String sql = "SELECT count(*),sum(o.realTotal) FROM desserthouse.`order` o  "
				+ "where o.isValid = 0 and o.sid = "+sid;
		List<Object[]> objects = baseDao.querySQL(sql);
		int invalidDeal = Integer.parseInt(objects.get(0)[0].toString());
		double invalidSum = Double.parseDouble(objects.get(0)[1].toString());
		sql = "SELECT count(*),sum(o.realTotal) FROM desserthouse.`order` o  "
				+ "where o.sid = "+sid;
		objects = baseDao.querySQL(sql);
		int deal = Integer.parseInt(objects.get(0)[0].toString());
		double num =  invalidDeal/(double)deal;
		num = (double)Math.round(num*10000)/100;
		InValidAnalysis ia = new InValidAnalysis();
		invalidSum = (double)Math.round(invalidSum);
		ia.invalidDeal = invalidDeal;
		ia.percent = num;
		ia.invalidSum = invalidSum;
		//analysis = "共有"+invalidDeal+"笔订单被取消，"+"占总订单的"+num+"%,如果挽回这些被取消的订单，则可以挽回"+invalidSum+"元。";
		return ia;
	}

	@Override
	public List<ShopYearRankItemVO> getShopYearRank() {
		String sql = "SELECT s.sid,s.sname,s.disname,ifnull(sum(oid),0) ,ifnull(sum(realTotal),0)"
				+ " FROM shop s  left join desserthouse.`order` o on o.sid = s.sid "
				+ "group by s.sid,s.sname,s.disname "
				+ "order by sum(oid) desc";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<ShopYearRankItemVO> syrList = new ArrayList<ShopYearRankItemVO>();
		for (Object[] obj : objects) {
			ShopYearRankItemVO syrvo = new ShopYearRankItemVO();
			syrvo.sid = (int) obj[0];
			syrvo.sname = (String) obj[1];
			syrvo.disname = (String) obj[2];
			syrvo.deal = Integer.parseInt(obj[3].toString());
			double num = (Double)obj[4];
			num = (double)Math.round(num*100)/100;
			syrvo.sum = num;
			syrList.add(syrvo);
		}
		return syrList;
	}

	@Override
	public List<DistrictYearRankVO> getDistrictYearRank() {
		String sql = "SELECT s.disname,ifnull(sum(oid),0) ,ifnull(sum(realTotal),0)"
				+ " FROM shop s  left join desserthouse.`order` o on o.sid = s.sid "
				+ "group by s.disname";
		List<Object[]> objects = baseDao.querySQL(sql);
		List<DistrictYearRankVO> syrList = new ArrayList<DistrictYearRankVO>();
		for (Object[] obj : objects) {
			DistrictYearRankVO syrvo = new DistrictYearRankVO();
			syrvo.disname = (String) obj[0];
			syrvo.deal = Integer.parseInt(obj[1].toString());
			double num = (Double)obj[2];
			num = (double)Math.round(num*100)/100;
			syrvo.sum = num;
			syrList.add(syrvo);
		}
		return syrList;
	}

	@Override
	public List<List<AutoGeneratingPlanItem>> getMonthExtreamAutoGeneratingPlan(int sid, int month, String orderType) {
		List<List<AutoGeneratingPlanItem>> agpList = new ArrayList<List<AutoGeneratingPlanItem>>();
		for(int i = 0;i<7;i++){
			String sql = "select d.did,d.name, ifnull(d1.amount,0),d.price from dessert d left join  "
					+ "(select od1.did as did,sum(od1.amount) as amount  from `order` o1 join orderdetail od1 on o1.oid = od1.oid, "
					+ "(SELECT DATE_FORMAT(o.orderTime,'%y-%m-%d') as dt FROM desserthouse.`order` o join orderdetail od on o.oid = od.oid "
					+ "where MONTH(o.orderTime)= "+month
					+ " and WEEKDAY(o.orderTime)= "+i
					+ " and o.sid = "+sid
					+ " group by DATE_FORMAT(o.orderTime,'%y-%m-%d')  "
					+ "order by sum(o.realTotal) "+orderType
					+ " limit 1) dtt "
					+ "where DATE_FORMAT(o1.orderTime,'%y-%m-%d')=dtt.dt "
					+ "group by od1.did) d1 on d.did=d1.did";
			List<Object[]> objects = baseDao.querySQL(sql);
			List<AutoGeneratingPlanItem> list = new ArrayList<AutoGeneratingPlanItem>();
			for (Object[] obj : objects) {
				AutoGeneratingPlanItem agpi = new AutoGeneratingPlanItem();
				agpi.did = (int) obj[0];
				agpi.dname = (String) obj[1];
				agpi.amount = Integer.parseInt(obj[2].toString());
				agpi.price = (int)((double)obj[3]);
				list.add(agpi);
			}
			agpList.add(list);
		}
		return agpList;
	}

	@Override
	public List<List<AutoGeneratingPlanItem>> getMonthExtreamAutoGeneratingPlan(int sid, int month) {
		List<List<AutoGeneratingPlanItem>> agpList = new ArrayList<List<AutoGeneratingPlanItem>>();
		for(int i = 0;i<7;i++){
			String sql = "select d.did,d.name,ifnull(v1.amount,0),d.price from dessert d left join  "
					+ "(select v.did,CAST( avg(v.amount) AS signed) as amount from  "
					+ "(SELECT DATE_FORMAT(o.orderTime,'%y-%m-%d') as dt,od.did as did,sum(od.amount) as amount FROM desserthouse.`order` o join orderdetail od on o.oid = od.oid "
					+ "where MONTH(o.orderTime)="+month
					+ " and WEEKDAY(o.orderTime)="+i
					+ " and o.sid = "+sid
					+ " group by DATE_FORMAT(o.orderTime,'%y-%m-%d'), od.did) as v "
					+ "group by v.did) as v1 on d.did=v1.did";
			List<Object[]> objects = baseDao.querySQL(sql);
			List<AutoGeneratingPlanItem> list = new ArrayList<AutoGeneratingPlanItem>();
			for (Object[] obj : objects) {
				AutoGeneratingPlanItem agpi = new AutoGeneratingPlanItem();
				agpi.did = (int) obj[0];
				agpi.dname = (String) obj[1];
				agpi.amount = Integer.parseInt(obj[2].toString());
				agpi.price = (int)((double)obj[3]);
				list.add(agpi);
			}
			agpList.add(list);
		}
		return agpList;
	}

	@Override
	public List<List<AutoGeneratingPlanItem>> getYearExtreamAutoGeneratingPlan(int sid, String orderType) {
		List<List<AutoGeneratingPlanItem>> agpList = new ArrayList<List<AutoGeneratingPlanItem>>();
		for(int i = 0;i<7;i++){
			String sql = "select d.did,d.name, ifnull(d1.amount,0),d.price from dessert d left join  "
					+ "(select od1.did as did,sum(od1.amount) as amount  from `order` o1 join orderdetail od1 on o1.oid = od1.oid, "
					+ "(SELECT DATE_FORMAT(o.orderTime,'%y-%m-%d') as dt FROM desserthouse.`order` o join orderdetail od on o.oid = od.oid "
					+ "where WEEKDAY(o.orderTime)= "+i
					+ " and o.sid = "+sid
					+ " group by DATE_FORMAT(o.orderTime,'%y-%m-%d')  "
					+ "order by sum(o.realTotal) "+orderType
					+ " limit 1) dtt "
					+ "where DATE_FORMAT(o1.orderTime,'%y-%m-%d')=dtt.dt "
					+ "group by od1.did) d1 on d.did=d1.did";
			List<Object[]> objects = baseDao.querySQL(sql);
			List<AutoGeneratingPlanItem> list = new ArrayList<AutoGeneratingPlanItem>();
			for (Object[] obj : objects) {
				AutoGeneratingPlanItem agpi = new AutoGeneratingPlanItem();
				agpi.did = (int) obj[0];
				agpi.dname = (String) obj[1];
				agpi.amount = Integer.parseInt(obj[2].toString());
				agpi.price = (int)((double)obj[3]);
				list.add(agpi);
			}
			agpList.add(list);
		}
		return agpList;
	}

	@Override
	public List<List<AutoGeneratingPlanItem>> getYearExtreamAutoGeneratingPlan(int sid) {
		List<List<AutoGeneratingPlanItem>> agpList = new ArrayList<List<AutoGeneratingPlanItem>>();
		for(int i = 0;i<7;i++){
			String sql = "select d.did,d.name,ifnull(v1.amount,0),d.price from dessert d left join  "
					+ "(select v.did,CAST( avg(v.amount) AS signed) as amount from  "
					+ "(SELECT DATE_FORMAT(o.orderTime,'%y-%m-%d') as dt,od.did as did,sum(od.amount) as amount FROM desserthouse.`order` o join orderdetail od on o.oid = od.oid "
					+ " where WEEKDAY(o.orderTime)="+i
					+ " and o.sid = "+sid
					+ " group by DATE_FORMAT(o.orderTime,'%y-%m-%d'), od.did) as v "
					+ "group by v.did) as v1 on d.did=v1.did";
			List<Object[]> objects = baseDao.querySQL(sql);
			List<AutoGeneratingPlanItem> list = new ArrayList<AutoGeneratingPlanItem>();
			for (Object[] obj : objects) {
				AutoGeneratingPlanItem agpi = new AutoGeneratingPlanItem();
				agpi.did = (int) obj[0];
				agpi.dname = (String) obj[1];
				agpi.amount = Integer.parseInt(obj[2].toString());
				agpi.price = (int)((double)obj[3]);
				list.add(agpi);
			}
			agpList.add(list);
		}
		return agpList;
	}
}
