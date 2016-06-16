package edu.nju.desserthouse.service;

import java.util.List;

import edu.nju.desserthouse.model.Bank;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.User;
import edu.nju.desserthouse.model.stavo.MemberMonthStaVO;
import edu.nju.desserthouse.model.stavo.MemberStaVO;

public interface MemberService {
	/*
	 * 注册新用户，记录其注册信息
	 */
	public void registerUser(Member member,User user);
	/*
	 * 通过id查找用户
	 */
	public Member findMemberById(int id);
	/*
	 * 更新用户
	 */
	public void updateMember(Member member);
	/*
	 * 充值后，更新用户和银行账户余额
	 */
	public void recharge(Member member,Bank bank);
	/*
	 * 根据银行卡获得银行卡信息
	 */
	public Bank findBankById(int id);
	/*
	 * 获得所有用户的注册信息
	 */
	public List<Member> getAllMemberList();
	/*
	 * 获得月份 返回三个等级客户的统计信息,month表示上一个月，数字
	 * list中有三个小list，每个小list中有对应的客户详细信息
	 */
	public List<List<MemberMonthStaVO>> getMemberMonthStaVO(int month);
	/*
	 * 会员购买趋势
	 */
	public  List<List<MemberStaVO>> getMemberSta();
}
