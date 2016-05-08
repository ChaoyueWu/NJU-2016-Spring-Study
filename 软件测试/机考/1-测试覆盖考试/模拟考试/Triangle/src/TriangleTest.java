import static org.junit.Assert.*;

import org.junit.Test;


public class TriangleTest {

	@Test
	public void testGetType() {
		//等边
		Triangle t1 = new Triangle(1,1,1);
		assertEquals("Regular",t1.getType(t1));
		//普通
		Triangle t2 = new Triangle(5,4,3);
		assertEquals("Scalene",t1.getType(t2));
		//等腰
		Triangle t3 = new Triangle(4,4,3);
		assertEquals("Isosceles",t1.getType(t3));
		//非三角形
		Triangle t4 = new Triangle(1,5,2);
		assertEquals("Illegal",t1.getType(t4));
		
		t4.getBorders();
		
		t2 = new Triangle(5,4,4);
		assertEquals("Isosceles",t1.getType(t2));
		
		t2 = new Triangle(4,5,4);
		assertEquals("Isosceles",t1.getType(t2));
		
		t2 = new Triangle(Long.MAX_VALUE+1,0,0);
		assertEquals("Illegal",t1.getType(t2));
		
		t2 = new Triangle(4,0,0);
		assertEquals("Illegal",t1.getType(t2));
		
		t2 = new Triangle(1,1,0);
		assertEquals("Illegal",t1.getType(t2));
		
		t2 = new Triangle(5,1,6);
		assertEquals("Illegal",t1.getType(t2));

	}


}
