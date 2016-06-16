package edu.nju.desserthouse.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.stavo.ProductStaVO;
import edu.nju.desserthouse.service.ProductStaService;

public class ProductStaAction extends BaseAction{
	@Autowired
	private ProductStaService productStaService;

	public ProductStaService getProductStaService() {
		return productStaService;
	}

	public void setProductStaService(ProductStaService productStaService) {
		this.productStaService = productStaService;
	}
	@Override
	public String execute() throws Exception {
		ProductStaVO psvo = productStaService.getProductStaVO();
		request.setAttribute("psvo", psvo);
		HttpSession session = request.getSession();
		String type = (String) session.getAttribute("type");
		if(type.equals("JL")){
			return "productSta";
		}else if(type.equals("ZJL")){
			return "productStaZJL";
		}
		return "login";
	}
}
