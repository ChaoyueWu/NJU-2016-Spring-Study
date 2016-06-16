package edu.nju.desserthouse.action;

import java.security.MessageDigest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.User;
import edu.nju.desserthouse.service.UserService;

public class LoginAction extends BaseAction{
	@Autowired
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}



	@Override
	public String execute() throws Exception {
		//判断是否为空
		String userId = request.getParameter("id");
		String password = request.getParameter("password");
		if(userId.length() == 0 || password.length() == 0){
			return "relogin";
		}else{
			int id = Integer.parseInt(userId);
			password = encryption(password);
			User user = userService.findUserById(id);
			if(user == null){
				System.out.println("user null");
				return "relogin";
			}else if(!password.equals(user.getPwd())){
				System.out.println("wrong pwd");
				return "relogin";
			}else{
				//需要增加service来到数据库获取数据，好在jsp页面中进行填写
				HttpSession session = request.getSession(true);
				char type = userId.charAt(0);
				if(type == '1'){
					session.setAttribute("type", "HY");
					session.setAttribute("id", id);
					return "memberMain";
				}else if(type == '2'){
					session.setAttribute("type", "GL");
					session.setAttribute("id", id);
					return "adminMain";
				}else if(type == '3'){
					session.setAttribute("type", "ZD");
					session.setAttribute("id", id);
					return "headMain";
				}else if(type == '4'){
					session.setAttribute("type", "FD");
					session.setAttribute("id", id);
					return "branchMain";
				}else if(type == '5'){
					session.setAttribute("type", "JL");
					session.setAttribute("id", id);
					return "managerMain";
				}else if(type == '6'){
					session.setAttribute("type", "ZJL");
					session.setAttribute("id", id);
					return "topManagerMain";
				}else{
					return "login";
				}
			}
		}
		
		

	}
	
	/*
	 * 计算密码的md5值
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
