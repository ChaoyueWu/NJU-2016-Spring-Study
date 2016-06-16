package edu.nju.desserthouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.desserthouse.dao.DessertDao;
import edu.nju.desserthouse.model.Dessert;
import edu.nju.desserthouse.service.DessertService;

public class DessertServiceImpl implements DessertService{
	@Autowired
	private DessertDao dessertDao;
	
	public DessertDao getDessertDao() {
		return dessertDao;
	}

	public void setDessertDao(DessertDao dessertDao) {
		this.dessertDao = dessertDao;
	}

	@Override
	public void createDessert(Dessert dessert) {
		dessertDao.save(dessert);
	}

	@Override
	public void deleteDessert(int id) {
		dessertDao.delete(id);
	}

	@Override
	public Dessert findDessert(int id) {
		return dessertDao.find(id);
	}

	@Override
	public void updateByDessertid(Dessert dessert) {
		dessertDao.updateByDessertId(dessert);
	}

	@Override
	public List<Dessert> getAllDessertList() {
		return dessertDao.getAllDessertList();
	}

}
