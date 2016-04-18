import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TriangleTest {
	private Triangle tr;
	@Before
	public void setUp() throws Exception {
		System.out.print("ini");
	}

	@Test
	public void testAll() {
		tr = new Triangle(0,0,0);
		assertEquals("Illegal",tr.getType(tr));
		
		tr = new Triangle(1,1,1);
		assertEquals("Regular",tr.getType(tr));
		
		tr = new Triangle(2,2,3);
		assertEquals("Isosceles",tr.getType(tr));
		
		tr = new Triangle(4,3,5);
		assertEquals("Scalene",tr.getType(tr));
		
		tr.getBorders();
	}

}
