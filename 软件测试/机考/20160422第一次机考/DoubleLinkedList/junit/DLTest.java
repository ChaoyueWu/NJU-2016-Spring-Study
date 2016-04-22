import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.Test;


public class DLTest {

	@Test
	public void test() {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		DoubleLinkedList dl2 = new DoubleLinkedList(list1);
		dl2.clear();
		Object oo = new Integer(12);
		dl2.add(0,oo);
		dl2.get(0);
		dl2.remove(0);
		
		
		DoubleLinkedList dl = new DoubleLinkedList();
		assertEquals(true,dl.repOK());
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		DoubleLinkedList dl1 = new DoubleLinkedList(list);
		assertEquals(true,dl1.repOK());
		assertEquals(2,dl1.size());
		Object o = new Integer(12);
		assertEquals(false,dl1.contains(o));
		dl1.repOK();

		assertEquals(true,dl1.add(o));
		assertEquals(true,dl1.contains(o));
		
		Object o1 = null;
		assertEquals(false,dl1.remove(o1));
		dl1.add(o1);
		assertEquals(true,dl1.remove(o1));
		
		Object o2 = new Integer(122);
		assertEquals(false,dl1.remove(o2));
		assertEquals(true,dl1.add(o2));
		assertEquals(true,dl1.remove(o2));
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testEntryEx() {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		DoubleLinkedList dl2 = new DoubleLinkedList(list1);
		Object oo = new Integer(12);
		dl2.add(0,oo);
		dl2.remove(-1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testEntryEx1() {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		DoubleLinkedList dl2 = new DoubleLinkedList(list1);
		Object oo = new Integer(12);
		dl2.add(0,oo);
		dl2.remove(2);
	}
	
	@Test
	public void test1() {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		DoubleLinkedList dl2 = new DoubleLinkedList(list1);
		Object oo = new Integer(12);
		dl2.add(0,oo);
		Object o = null;
		dl2.add(o);
		dl2.indexOf(o);
		
		dl2.add(0, o);
		dl2.indexOf(o);
		
		dl2.lastIndexOf(o);
		
		dl2.lastIndexOf(oo);
		
		Object o1 = new Integer(1);
		dl2.lastIndexOf(o1);
	}
	
	@Test
	public void testToArray() {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		DoubleLinkedList dl2 = new DoubleLinkedList(list1);
		Integer[]a = new Integer[3];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		dl2.toArray(a);
	}
	
	@Test
	public void testToArray1() {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(-3);
		DoubleLinkedList dl2 = new DoubleLinkedList(list1);
		Integer[]a = new Integer[2];
		a[0] = 1;
		a[1] = 2;
		dl2.toArray(a);
	}
	
	@Test
	public void testInList(){
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(-3);
		DoubleLinkedList dl2 = new DoubleLinkedList(list1);
	}
	
	@Test
	public void test4(){
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(-3);
		DoubleLinkedList dl2 = new DoubleLinkedList(list1);
	}
	
	@Test
	public void test5(){
		DoubleLinkedList dl2 = new DoubleLinkedList();
		Object o = null;
		dl2.indexOf(o);
	}
	
	@Test
	public void test6(){
		DoubleLinkedList dl2 = new DoubleLinkedList();
		Object o = null;
		dl2.add(o);
		dl2.indexOf(o);
	}
	
	@Test
	public void test7(){
		DoubleLinkedList dl2 = new DoubleLinkedList();
		Object o = null;
		Object o1 = new Integer(1);
		dl2.add(o1);
		dl2.add(o);
		dl2.indexOf(o);
	}
	
	@Test
	public void test8(){
		DoubleLinkedList dl2 = new DoubleLinkedList();
		Object o = null;
		Object o1 = new Integer(1);
		Object o2 = new Integer(2);
		dl2.add(o1);
		dl2.add(o);
		dl2.indexOf(o2);
	}
	
	@Test
	public void test9() {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		DoubleLinkedList dl2 = new DoubleLinkedList(list1);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		
		dl2.addAll(0, list2);
	}
	
	@Test
	public void test10() {
		DoubleLinkedList dl2 = new DoubleLinkedList();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		Object o = null;
		Object o2 = new Integer(2);
		dl2.add(o2);
		Object o1 = null;
		dl2.add(o1);
		
		dl2.lastIndexOf(o);
		
	}
	
	
	
}
