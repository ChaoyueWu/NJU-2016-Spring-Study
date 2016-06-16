package edu.nju.desserthouse.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Dessert;
import edu.nju.desserthouse.service.DessertService;

public class UpdateDessertAction extends BaseAction{
	@Autowired
	private DessertService dessertService;
	private String name;
	private String image;
	private String did;
	
	public DessertService getDessertService() {
		return dessertService;
	}

	public void setDessertService(DessertService dessertService) {
		this.dessertService = dessertService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	@Override
	public String execute() throws Exception {
		
		System.out.println("name: "+name+" img:"+image+" did:"+did);
		
		Dessert dessert = dessertService.findDessert(Integer.valueOf(did));
		dessert.setName(name);;
		dessert.setImage(image);
		dessertService.updateByDessertid(dessert);

		List<Dessert> dessertList = dessertService.getAllDessertList();
		request.setAttribute("dessertList", dessertList);
		return "dessertManage";
		
	}
}
