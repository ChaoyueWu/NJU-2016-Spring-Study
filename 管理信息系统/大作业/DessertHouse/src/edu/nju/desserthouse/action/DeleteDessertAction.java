package edu.nju.desserthouse.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Dessert;
import edu.nju.desserthouse.service.DessertService;

public class DeleteDessertAction extends BaseAction{
	@Autowired
	private DessertService dessertService;
	private String did;
	
	public DessertService getDessertService() {
		return dessertService;
	}

	public void setDessertService(DessertService dessertService) {
		this.dessertService = dessertService;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	@Override
	public String execute() throws Exception {
		
		System.out.println("did: "+did);
		dessertService.deleteDessert(Integer.valueOf(did));

		List<Dessert> dessertList = dessertService.getAllDessertList();
		request.setAttribute("dessertList", dessertList);
		return "dessertManage";
		
	}
}
