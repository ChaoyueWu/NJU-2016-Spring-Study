package edu.nju.desserthouse.action;

import java.security.MessageDigest;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Member;
import edu.nju.desserthouse.model.User;
import edu.nju.desserthouse.service.MemberService;
import edu.nju.desserthouse.service.UserService;

public class UpdateInfoAction extends BaseAction {
	@Autowired
	private MemberService memberService;
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String execute() throws Exception {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		Member member = memberService.findMemberById(id);
		User user = userService.findUserById(id);
		String password = request.getParameter("password1");
		String birth = request.getParameter("birth");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		Date date = java.sql.Date.valueOf(birth);
		member.setBirth(date);
		member.setSex(Integer.valueOf(gender));
		member.setAddress(address);
		memberService.updateMember(member);
		password = encryption(password);
		user.setPwd(password);
		userService.updateUser(user);
		session.setAttribute("member", member);
		return "personalInfo";
	}
	/*
	 * º∆À„√‹¬Îµƒmd5÷µ
	 */
	 private String encryption(String plainText) {
	        String re_md5 = new String();
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            md.update(plainText.getBytes());
	            byte b[] = md.digest();
	 
	            int i;
	 
	            StringBuffer buf = new StringBuffer("");
	            for (int offset = 0; offset < b.length; offset++) {
	                i = b[offset];
	                if (i < 0)
	                    i += 256;
	                if (i < 16)
	                    buf.append("0");
	                buf.append(Integer.toHexString(i));
	            }
	 
	            re_md5 = buf.toString();
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return re_md5;
	    }
}
