package edu.nju.desserthouse.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.User;
import edu.nju.desserthouse.service.UserService;

public class GetMemberIdAction  extends BaseAction{
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
		List<User> list= userService.getAllUerList();
		int num = 1000000;
		int id;
		for(User user : list){
			id = user.getId();
			if(id<2000000){
				if(num < id){
					num = id;
				}
			}
		}
		num++; 
		ServletActionContext.getRequest().setAttribute("id", String.valueOf(num));  
		return "register";
	}
}
