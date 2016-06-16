package edu.nju.desserthouse.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.BankDao;
import edu.nju.desserthouse.dao.MemberDao;
import edu.nju.desserthouse.dao.UserDao;
import edu.nju.desserthouse.model.Bank;
import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.User;
import edu.nju.desserthouse.model.stavo.MemberMonthStaVO;
import edu.nju.desserthouse.model.stavo.MemberStaVO;
import edu.nju.desserthouse.service.MemberService;

public class MemberServiceImpl implements MemberService{

	@Autowired
	private UserDao userDao;
	private MemberDao memberDao;
	private BankDao bankDao;
	
	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public MemberDao getMemberDao() {
		return memberDao;
	}


	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}


	public BankDao getBankDao() {
		return bankDao;
	}


	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}


	@Override
	public void registerUser(Member member, User user) {
		userDao.save(user);
		memberDao.save(member);
	}


	@Override
	public Member findMemberById(int id) {
		return memberDao.find(id);
	}


	@Override
	public void updateMember(Member member) {
		memberDao.updateByUserid(member);
	}


	@Override
	public void recharge(Member member, Bank bank) {
		memberDao.updateByUserid(member);
		bankDao.updateByBankid(bank);
	}


	@Override
	public Bank findBankById(int id) {
		return bankDao.find(id);
	}


	@Override
	public List<Member> getAllMemberList() {
		return memberDao.getAllMemberList();
	}


	@Override
	public List<List<MemberMonthStaVO>> getMemberMonthStaVO(int month) {
		List<List<MemberMonthStaVO>> mmsList = new ArrayList<List<MemberMonthStaVO>>();
		for(int i = 1;i<=3;i++){
			mmsList.add(memberDao.getmmsList(i, month));
		}
		return mmsList;
	}


	@Override
	public  List<List<MemberStaVO>> getMemberSta() {
		return memberDao.getMemberSta();
	}

}
