import static org.junit.Assert.*;

import org.junit.Test;

public class TestTriangle{

	@Test
	public void testIsTriangle1(){
		Triangle t = new Triangle(-1,10,2);
		assertFalse(t.isTriangle(t));
	}
	
	@Test
	public void testIsTriangle2(){
		// according to the mutant, this test case should fail
		Triangle t = new Triangle(3,2,1);
		assertFalse(t.isTriangle(t));
	}
	
	@Test
	public void testIsTriangle3(){
		Triangle t = new Triangle(3,1,2);
		assertFalse(t.isTriangle(t));
	}
	
	@Test
	public void testIsTriangle4(){
		Triangle t = new Triangle(2,1,3);
		assertFalse(t.isTriangle(t));
	}
	
	@Test
	public void testIsTriangle5(){
		Triangle t = new Triangle(2,3,1);
		assertFalse(t.isTriangle(t));
	}
	
	@Test
	public void testIsTriangle6(){
		Triangle t = new Triangle(1,2,3);
		assertFalse(t.isTriangle(t));
	}
	
	@Test
	public void testIsTriangle7(){
		Triangle t = new Triangle(1,3,2);
		assertFalse(t.isTriangle(t));
	}
	
	@Test
	public void testType1(){
		Triangle t = new Triangle(4,3,2);
		assertEquals(t.getType(t),"Scalene");
	}
	
	@Test
	public void testType2(){
		Triangle t = new Triangle(3,3,2);
		assertEquals(t.getType(t),"Isoceles");
	}
	
	@Test
	public void testType3(){
		Triangle t = new Triangle(3,3,3);
		assertEquals(t.getType(t),"Regular");
	}
	
	@Test
	public void testType4(){
		Triangle t = new Triangle(2,3,3);
		assertEquals(t.getType(t),"Isoceles");
	}
	
}