import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class Test2 {
	private Triangle tr;
	@Before
	public void setUp() throws Exception {
		System.out.print("ini");
	}

	@Test
	public void testAll() {
		tr = new Triangle(0,0,0);
		assertEquals("Illegal",tr.getType(tr));
		
		tr.getBorders();
	}
}
