package edu.nju.desserthouse.dao;

import java.util.List;

import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.stavo.MemberMonthStaVO;
import edu.nju.desserthouse.model.stavo.MemberStaVO;

public interface MemberDao {
	/*
	 * 像数据库中插入一条member记录
	 */
	public void save(Member member);
	
	
	/*
	 * 根据id查找member对象,如果找到则返回这个对象,否则返回null
	 */
	public Member find(int id);
	
	
	/*
	 * 根据id更新member表的一条记录
	 */
	public void updateByUserid(Member member);
	/*
	 * 获得所有元组
	 */
	public List<Member> getAllMemberList();
	/*
	 * 根据客户等级和month获得对应所有客户的每月消费统计
	 */
	public List<MemberMonthStaVO> getmmsList(int level,int month);
	/*
	 * 会员购买趋势
	 */
	public  List<List<MemberStaVO>> getMemberSta();
	
}
