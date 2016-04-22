import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;


public class MatrixCTest {

	@Test
	public void test() {
		int[][] a1 = new int[][]{{1,2},{3,4},{5,6}};
		int[][] a2 = new int[][]{{1,2},{3,4},{5,7}};
		MatrixC m1 = new MatrixC(a1);
		MatrixC m2 = new MatrixC(a2);
		m1.equals(m2);
		m1.getArray();
		m1.plus(m2);
		
		int[][] a3 = new int[][]{{1,2},{3,4}};
		int[][] a4 = new int[][]{{1,2},{3,4}};
		MatrixC m3 = new MatrixC(a3);
		MatrixC m4 = new MatrixC(a4);
		
		m3.plus(m1);
		m3.times(m4);
		m3.times(1);
		m3.transpose();
		m3.times(m1);
		m3.print();
		m3.equals(m4);
		Object o = new Integer(1);
		m3.equals(o);
		m3.equals(m1);
		//m3.plusFromConsole();
	}
	
	@Test
	public void testC() {
		int[][] a1 = new int[][]{{1,2},{3,4},{5,6}};
		MatrixC m1 = new MatrixC(a1);

		int[][] data = {
    			{1 , 1 , 1},
    			{1 , 1 , 1},
    			{1 , 1 , 1}
    	};
		
		 String s = "3 2 1 1 1 1 1 1";
		 
		 InputStream in = new ByteArrayInputStream(s.getBytes());
	     System.setIn(in);
	     m1.plusFromConsole();
	}
	
	@Test
	public void testC1() {
		int[][] a1 = new int[][]{{1,2},{3,4},{5,6}};
		MatrixC m1 = new MatrixC(a1);
		
		 String s = "2 2  1 1 1 1 1";
		 
		 InputStream in = new ByteArrayInputStream(s.getBytes());
	     System.setIn(in);
	     m1.plusFromConsole();
	}
	@Test
	public void testC2() {
		int[][] a1 = new int[][]{{1,2},{3,4},{5,6}};
		MatrixC m1 = new MatrixC(a1);
		
		 String s = "3 1 1 1 1";
		 
		 InputStream in = new ByteArrayInputStream(s.getBytes());
	     System.setIn(in);
	     m1.plusFromConsole();
	}
	
	@Test
	public void testC3() {
		int[][] a1 = new int[][]{{1,2},{3,4}};
		MatrixC m1 = new MatrixC(a1);
		
		 String s = "2 2 1 1 1 1";
		 
		 InputStream in = new ByteArrayInputStream(s.getBytes());
	     System.setIn(in);
	     m1.timesFromConsole();
	}
	
	@Test
	public void testC4() {
		int[][] a1 = new int[][]{{1,2},{3,4}};
		MatrixC m1 = new MatrixC(a1);
		
		 String s = "3 2 1 1 1 1 1 1";
		 
		 InputStream in = new ByteArrayInputStream(s.getBytes());
	     System.setIn(in);
	     m1.timesFromConsole();
	}

}
