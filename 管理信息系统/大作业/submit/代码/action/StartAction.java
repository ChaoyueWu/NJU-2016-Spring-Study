package edu.nju.desserthouse.action;

import javax.servlet.http.HttpSession;

public class StartAction extends BaseAction{
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		try{
			HttpSession session = request.getSession(false);
			if(session==null || session.getAttribute("type")==null){
				session = request.getSession(true);
				session.setAttribute("type", "YK");
				return "login";
			}else if(session.getAttribute("type")=="HY"){
				return "memberMain";
			}else if(session.getAttribute("type")=="GL"){
				return "adminMain";
			}else if(session.getAttribute("type")=="ZD"){
				return "headMain";
			}else if(session.getAttribute("type")=="FD"){
				return "branchMain";
			}else if(session.getAttribute("type")=="JL"){
				return "managerMain";
			}else if(session.getAttribute("type")=="ZJL"){
				return "topManagerMain";
			}else{
				return "login";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	
	
}
