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
		//像xxx &&xxx这种一般应该都会有1/4覆盖不到吧？但是为什么最后这条语句通过了呢？照理来说应该返回false啊？
		
		int[] a3 = new int[]{2,2,2,2,};
		ap = new ArrayPartition(a3);
		ap.partition();

		int[] a4 = new int[]{2,3,2,2,};
		ap = new ArrayPartition(a4);
		assertEquals(false,ap.isWeaklySorted());
		
	}

}
