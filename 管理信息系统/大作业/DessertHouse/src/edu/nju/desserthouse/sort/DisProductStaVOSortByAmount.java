package edu.nju.desserthouse.sort;

import java.util.Comparator;

import edu.nju.desserthouse.model.stavo.DisProductStaVO;

public class DisProductStaVOSortByAmount implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		DisProductStaVO d1 = (DisProductStaVO) o1;
		DisProductStaVO d2 = (DisProductStaVO) o2;
		if(d1.amount<d2.amount){
			return 1;
		}else{
			return -1;
		}
	}

}
