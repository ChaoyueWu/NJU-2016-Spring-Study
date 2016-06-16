package edu.nju.desserthouse.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.model.Dessert;
import edu.nju.desserthouse.service.DessertService;

public class AddDessertAction extends BaseAction{
	@Autowired
	private DessertService dessertService;
	private String name;
	private String image;
	
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

	@Override
	public String execute() throws Exception {
		
		System.out.println("name: "+name+" img:"+image);
		Dessert dessert = new  Dessert();
		dessert.setName(name);;
		dessert.setImage(image);
		dessertService.createDessert(dessert);

		List<Dessert> dessertList = dessertService.getAllDessertList();
		request.setAttribute("dessertList", dessertList);
		return "dessertManage";
		
	}
}
