import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SortingTest {
	
	private Sorting s;
	private int[] a;
	@Before
	public void setUp() throws Exception {
		s = new Sorting();
		a = new int[]{4,2,5,7,1,3,9,4,2,5,7,1,3,9,4,2,5,7,1,3,9};
	}

	@Test
	public void testIsSorted() {
		s.insertionSort(a);
		assertTrue(s.isSorted(a));
		
		int[] t1 = new int[]{2,1};
		assertEquals(false,s.isSorted(t1));
	}

	@Test
	public void testQuicksort1() {
		Sorting.quicksort(a);
		assertTrue(s.isSorted(a));
	}
	
	@Test
	public void testQuicksort2() {
		//覆盖未到达的median分支
		int[] t1 = new int[]{11,2,5,7,1,1,0,1,2,5,7,1,8};
		Sorting.quicksort(t1);
		assertTrue(s.isSorted(t1));
	}

	@Test
	public void testSwapReferences() {
		Integer[] a1 = new Integer[]{1,3,4,6,7,9,5,4,3};
		Integer x = a1[1];
		Sorting.swapReferences(a1, 1, 6);
		assertEquals(x,a1[6]);
	}

	@Test
	public void testSwap() {
		int x = a[2];
		Sorting.swap(a, 2, 6);
		assertEquals(a[6],x);
	}

}
