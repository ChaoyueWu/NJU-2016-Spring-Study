package edu.nju.desserthouse.common;

import java.util.Comparator;

import edu.nju.desserthouse.model.DessertVO;

public class SortByAmount implements Comparator {
	 public int compare(Object o1, Object o2) {
		 DessertVO d1 = (DessertVO) o1;
		 DessertVO d2 = (DessertVO) o2;
		 if(d1.getAmount()>d2.getAmount()){
			 return 1;
		 }else{
			 return 0;
		 }
	 }
}
