import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class NextdayTest {

	private Nextday nd; 
	@Before
	public void setUp() throws Exception {
		nd = new Nextday();
	}

	@Test
	public void testNextDay() {
		Date d1 = new Date(10,23,2016);
		Date d2 = new Date(10,24,2016);
		assertEquals(d2,nd.nextDay(d1));
		
		d1 = new Date(12,23,2016);
		d2 = new Date(12,24,2016);
		assertEquals(d2,nd.nextDay(d1));
		
		d1 = new Date(12,31,2016);
		d2 = new Date(1,1,2017);
		assertTrue(nd.nextDay(d1).equals(d2));
		d2 = new Date(1,1,2016);
		assertTrue(!(nd.nextDay(d1).equals(d2)));
		d1.toString();
		d1.printDate();
		
	}

}
