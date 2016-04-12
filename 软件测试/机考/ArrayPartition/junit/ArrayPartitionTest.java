import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ArrayPartitionTest {

	private ArrayPartition ap;
	private int[] a;
	@Before
	public void setUp() throws Exception {
		a = new int[] {1,3,2,4,5};
		ap = new ArrayPartition(a);
	}

	@Test
	public void testIsWeaklySorted1() {
		ap.partition();
		assertTrue(ap.isWeaklySorted());
	}
	
	@Test
	public void testIsWeaklySorted2() {
		a = new int[] {4,6,5,1,5,3,4};
		ap = new ArrayPartition(a);
		
		ap.partition();
		assertTrue(ap.isWeaklySorted());
	}
	
	@Test
	public void testIsWeaklySorted3() {
		a = new int[] {5,3,3,4,3,8,9,10,11};
		ap = new ArrayPartition(a);
		
		ap.partition();
		assertTrue(ap.isWeaklySorted());
	}

}
