import static org.junit.Assert.*;

import org.junit.Test;


public class ArrayPartitionTest {

	private ArrayPartition ap;
	@Test
	public void test() {
		int[] a1 = new int[]{1};
		int[] a2 = new int[]{4,2,5,7,1,3,9};
		ap = new ArrayPartition(a1);
		ap.partition();
		assertTrue(ap.isWeaklySorted());
		
		ap = new ArrayPartition(a2);
		ap.partition();
		assertTrue(ap.isWeaklySorted());
		
		int[] a3 = new int[]{2,2,2,2,};
		ap = new ArrayPartition(a3);
		ap.partition();

		int[] a4 = new int[]{2,3,2,2,};
		ap = new ArrayPartition(a4);
		assertEquals(false,ap.isWeaklySorted());
		
	}

}
