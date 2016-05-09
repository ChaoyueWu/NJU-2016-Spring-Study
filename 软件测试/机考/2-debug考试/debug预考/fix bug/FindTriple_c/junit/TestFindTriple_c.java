import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestFindTriple_c {

	@Test
	public void test1(){
		int[] test = {-1, 0, 1, 2, -1, -4};
		ArrayList<ArrayList<Integer>> result = FindTriple_c.three_summary(test);
		ArrayList<Integer> list0 = new ArrayList<Integer>();
		list0.add(-1);
		list0.add(-1);
		list0.add(2);
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(-1);
		list1.add(0);
		list1.add(1);
		System.out.println(result);
		assertTrue(result.contains(list0)&&result.contains(list1));
	}

	@Test
	public void test2(){
		int[] test = {-5, 0, 1, 5, 2, 3};
		ArrayList<ArrayList<Integer>> result = FindTriple_c.three_summary(test);
		ArrayList<Integer> list0 = new ArrayList<Integer>();
		list0.add(-5);
		list0.add(0);
		list0.add(5);
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(-5);
		list1.add(2);
		list1.add(3);
		System.out.println(result);
		assertTrue(result.contains(list0)&&result.contains(list1));
	}

	@Test
	public void test3(){
		int[] test = {-2, 1, 1, -5, 4, 7};
		ArrayList<ArrayList<Integer>> result = FindTriple_c.three_summary(test);
		ArrayList<Integer> list0 = new ArrayList<Integer>();
		list0.add(-5);
		list0.add(-2);
		list0.add(7);
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(-5);
		list1.add(1);
		list1.add(4);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(-2);
		list2.add(1);
		list2.add(1);
		System.out.println(result);
		assertTrue(result.contains(list0)&&result.contains(list1)&&result.contains(list2));
	}

	@Test
	public void test4(){
		int[] test = {0};
		ArrayList<ArrayList<Integer>> result = FindTriple_c.three_summary(test);
		assertTrue(result.size()==0);
	}

	@Test
	public void test5(){
		int[] test = {1,-2,1};
		ArrayList<ArrayList<Integer>> result = FindTriple_c.three_summary(test);
		ArrayList<Integer> list0 = new ArrayList<Integer>();
		list0.add(-2);
		list0.add(1);
		list0.add(1);
		System.out.println(result);
		assertTrue(result.contains(list0));
	}

	@Test
	public void test6(){
		int[] test = {1,1,-2};
		ArrayList<ArrayList<Integer>> result = FindTriple_c.three_summary(test);
		ArrayList<Integer> list0 = new ArrayList<Integer>();
		list0.add(-2);
		list0.add(1);
		list0.add(1);
		System.out.println(result);
		assertTrue(result.contains(list0));
	}

	@Test
	public void test7(){
		int[] test = {1,1,-2,6,-3,4,-9,11,2,-6};
		ArrayList<ArrayList<Integer>> result = FindTriple_c.three_summary(test);
		ArrayList<Integer> list0 = new ArrayList<Integer>();
		list0.add(-9);
		list0.add(-2);
		list0.add(11);
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(-6);
		list1.add(2);
		list1.add(4);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(-3);
		list2.add(1);
		list2.add(2);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(-2);
		list3.add(1);
		list3.add(1);
		System.out.println(result);
		assertTrue(result.contains(list0)&&result.contains(list1)&&result.contains(list2)&&result.contains(list3));
	}

	@Test
	public void test8(){
		int[] test = {-10,9,6,-4,8,-2,-2,-5,15,-1};
		ArrayList<ArrayList<Integer>> result = FindTriple_c.three_summary(test);
		ArrayList<Integer> list0 = new ArrayList<Integer>();
		list0.add(-10);
		list0.add(-5);
		list0.add(15);
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(-5);
		list1.add(-4);
		list1.add(9);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(-5);
		list2.add(-1);
		list2.add(6);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(-4);
		list3.add(-2);
		list3.add(6);
		assertTrue(result.contains(list0)&&result.contains(list1)&&result.contains(list2)&&result.contains(list3));
	}

	@Test
	public void test9(){
		int[] test = {6,5,3,2,-3,-1,-2,-8,0,-5,-11,4};
		ArrayList<ArrayList<Integer>> result = FindTriple_c.three_summary(test);
		ArrayList<Integer> list0 = new ArrayList<Integer>();
		list0.add(-11);
		list0.add(5);
		list0.add(6);
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(-8);
		list1.add(2);
		list1.add(6);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(-8);
		list2.add(3);
		list2.add(5);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(-5);
		list3.add(-1);
		list3.add(6);
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		list4.add(-5);
		list4.add(0);
		list4.add(5);
		ArrayList<Integer> list5 = new ArrayList<Integer>();
		list5.add(-5);
		list5.add(2);
		list5.add(3);
		ArrayList<Integer> list6 = new ArrayList<Integer>();
		list6.add(-3);
		list6.add(-2);
		list6.add(5);
		ArrayList<Integer> list7 = new ArrayList<Integer>();
		list7.add(-3);
		list7.add(-1);
		list7.add(4);
		ArrayList<Integer> list8 = new ArrayList<Integer>();
		list8.add(-3);
		list8.add(0);
		list8.add(3);
		ArrayList<Integer> list9 = new ArrayList<Integer>();
		list9.add(-2);
		list9.add(-1);
		list9.add(3);
		ArrayList<Integer> list10 = new ArrayList<Integer>();
		list10.add(-2);
		list10.add(0);
		list10.add(2);
		assertTrue(result.contains(list0)&&result.contains(list1)&&result.contains(list2)&&result.contains(list3)&&result.contains(list4)&&result.contains(list5)&&result.contains(list6)&&result.contains(list7)&&result.contains(list8)&&result.contains(list9)&&result.contains(list10));
	}
	@Test
	public void test10(){
		int[] test = {1,1,1,-1,-1,-1,2,-2};
		ArrayList<ArrayList<Integer>> result = FindTriple_c.three_summary(test);
		ArrayList<Integer> list0 = new ArrayList<Integer>();
		list0.add(-2);
		list0.add(1);
		list0.add(1);
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(-1);
		list1.add(-1);
		list1.add(2);
		assertTrue(result.contains(list0)&&result.contains(list1));
	}
	
	@Test
	public void test11(){
		int[] test = {-1,-1,-1,-1,-1,-1,0};
		ArrayList<ArrayList<Integer>> result = FindTriple_c.three_summary(test);
		assertTrue(result.size()==0);
	}
	
	@Test
	public void test12(){
		int[] test = {-3,1,2,-4,2,7,3,-10,-9,-5,19,14,-33,15};
		ArrayList<ArrayList<Integer>> result = FindTriple_c.three_summary(test);
		ArrayList<Integer> list0 = new ArrayList<Integer>();
		list0.add(-33);
		list0.add(14);
		list0.add(19);
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(-10);
		list1.add(-9);
		list1.add(19);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(-10);
		list2.add(-5);
		list2.add(15);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(-10);
		list3.add(-4);
		list3.add(14);
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		list4.add(-10);
		list4.add(3);
		list4.add(7);
		ArrayList<Integer> list5 = new ArrayList<Integer>();
		list5.add(-9);
		list5.add(-5);
		list5.add(14);
		ArrayList<Integer> list6 = new ArrayList<Integer>();
		list6.add(-9);
		list6.add(2);
		list6.add(7);
		ArrayList<Integer> list7 = new ArrayList<Integer>();
		list7.add(-5);
		list7.add(2);
		list7.add(3);
		ArrayList<Integer> list8 = new ArrayList<Integer>();
		list8.add(-4);
		list8.add(-3);
		list8.add(7);
		ArrayList<Integer> list9 = new ArrayList<Integer>();
		list9.add(-4);
		list9.add(1);
		list9.add(3);
		ArrayList<Integer> list10 = new ArrayList<Integer>();
		list10.add(-4);
		list10.add(2);
		list10.add(2);
		ArrayList<Integer> list11 = new ArrayList<Integer>();
		list11.add(-3);
		list11.add(1);
		list11.add(2);
		assertTrue(result.contains(list0)&&result.contains(list1)&&result.contains(list2)&&result.contains(list3)&&result.contains(list4)&&result.contains(list5)&&result.contains(list6)&&result.contains(list7)&&result.contains(list8)&&result.contains(list9)&&result.contains(list10)&&result.contains(list11));
	}

}
