import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class NextdayTest {


	@Test
	public void testNextDay() {
		Nextday nd = new Nextday();
		Date d1 = new Date(10,23,2016);
		Date d2 = new Date(10,24,2016);
		assertEquals(d2,Nextday.nextDay(d1));
		d1.toString();
		d1.printDate();
		
		Date d3 = new Date(2,28,2016);
		Date d4 = new Date(2,29,2016);
		assertEquals(d4,Nextday.nextDay(d3));
		
		Date d5 = new Date(2,28,2015);
		Date d6 = new Date(3,1,2015);
		assertEquals(d6,Nextday.nextDay(d5));
		
		Date d7 = new Date(12,31,2015);
		Date d8 = new Date(1,1,2016);
		assertEquals(d8,Nextday.nextDay(d7));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testYearEx() {
		Year y = new Year(0);
	}

	@Test
	public void testYearIncrement(){
		Year y = new Year(-1);
		assertTrue(y.increment());
	}
	
	@Test
	public void testYearIsLeap(){
		Year y = new Year(-1);
		assertTrue(y.isLeap());
		
		Year y1 = new Year(1600);
		assertTrue(y1.isLeap());
		
		Year y2 = new Year(-1605);
		assertTrue(y2.isLeap());
		
		Year y3 = new Year(-1602);
		assertEquals(false,y3.isLeap());
	}
	
	@Test
	public void testYearEquals(){
		Year y = new Year(1);
		Object o = new Integer(1);
		assertEquals(false,y.equals(o));
		
		Year y1 = new Year(2);
		Object o1 = y1;
		assertEquals(false,y.equals(o1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMonthEx() {
		Year y = null;
		Month m = new Month(0,y);
	}
	
	@Test
	public void testMonthEx1() {
		Year y1 = new Year(2009);
		Month m1 = new Month(0,y1);
	}
	
	@Test
	public void testMonthEx2() {
		Year y1 = new Year(2009);
		Month m1 = new Month(20,y1);
	}
	
	@Test
	public void testMonthEquals() {
		Year y = new Year(2016);
		Month m = new Month(8,y);
		Object o = new Integer(1);
		assertEquals(false,m.equals(o));
		
		Year y1 = new Year(2015);
		Month m1 = new Month(8,y1);
		Object o1 = m1;
		assertEquals(false,m.equals(o1));
		
		Month m2 = new Month(7,y);
		Object o2 = m2;
		assertEquals(false,m.equals(o2));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDayEx() {
		Month m = null;
		Day d = new Day(1,m);
	}
	
	@Test
	public void testDayEx1() {
		Year y = new Year(2009);
		Month m = new Month(2,y);
		Day d = new Day(0,m);
	}
	
	@Test
	public void testDayEx2() {
		Year y = new Year(2009);
		Month m1 = new Month(2,y);
		Day d1 = new Day(30,m1);
	}
	
	
	@Test
	public void testDayEquals() {
		Year y = new Year(2016);
		Month m = new Month(8,y);
		Day d = new Day(14,m);
		Object o = new Integer(1);
		assertEquals(false,d.equals(o));
		
		Year y1 = new Year(2015);
		Month m1 = new Month(8,y1);
		Day d1 = new Day(15,m1);
		Object o1 = d1;
		assertEquals(false,d.equals(o1));
		
		Month m2 = new Month(7,y);
		Day d2 = new Day(15,m2);
		Object o2 = d2;
		assertEquals(false,d.equals(o2));
		
		Month m3 = new Month(7,y);
		Day d3 = new Day(14,m3);
		Object o3 = d3;
		assertEquals(false,d.equals(o3));
	}
	
	@Test
	public void testDateEquals() {
		Date d = new Date(10,22,2016);
		Object o = new Integer(1);
		assertEquals(false,d.equals(o));
		
		Object o1 = new Date(10,23,2016);
		assertEquals(false,d.equals(o1));
		
		Object o2 = new Date(11,22,2016);
		assertEquals(false,d.equals(o2));
		
		Object o3 = new Date(11,22,2015);
		assertEquals(false,d.equals(o3));
	}
}
