package edu.nju.desserthouse.sort;

import java.util.Comparator;

import edu.nju.desserthouse.model.stavo.CateoryProductStaVO;

public class CateoryProductStaVOSortByAmount implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		CateoryProductStaVO d1 = (CateoryProductStaVO) o1;
		CateoryProductStaVO d2 = (CateoryProductStaVO) o2;
		if(d1.amount<d2.amount){
			return 1;
		}else{
			return -1;
		}
	}

}
