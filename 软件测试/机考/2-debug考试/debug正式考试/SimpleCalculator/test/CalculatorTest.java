import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void test1() {
		SimpleCalculator calculator = new SimpleCalculator();
		int value = calculator.calculate("2-(3+2-(8-1))");
		assertEquals(value,4);
	}
	@Test
	public void test2() {
		SimpleCalculator calculator = new SimpleCalculator();
		int value = calculator.calculate("1-(2-3)");
		assertEquals(value,2);
	}
	
	@Test
	public void test3() {
		SimpleCalculator calculator = new SimpleCalculator();
		int value = calculator.calculate("4+(5-8)");
		assertEquals(value,1);
	}
	
	@Test
	public void test4() {
		SimpleCalculator calculator = new SimpleCalculator();
		int value = calculator.calculate("(1+(4+5+2)-3)+(6+8)");
		assertEquals(value,23);
	}
	
	@Test
	public void test5() {
		SimpleCalculator calculator = new SimpleCalculator();
		int value = calculator.calculate("(1-2)+(2-3)");
		assertEquals(value,-2);
	}
	
	@Test
	public void test6() {
		SimpleCalculator calculator = new SimpleCalculator();
		int value = calculator.calculate("(5-(2+(5)))");
		assertEquals(value,-2);
	}
	
	@Test
	public void test7() {
		SimpleCalculator calculator = new SimpleCalculator();
		int value = calculator.calculate("(1-3)+(6+8)");
		assertEquals(value,12);
	}
	@Test
	public void test8() {
		SimpleCalculator calculator = new SimpleCalculator();
		int value = calculator.calculate("1-3+(6+8)");
		assertEquals(value,12);
	}
	
	@Test
	public void test9() {
		SimpleCalculator calculator = new SimpleCalculator();
		int value = calculator.calculate(" 0 ");
		assertEquals(value,0);
	}
	
	@Test
	public void test10() {
		SimpleCalculator calculator = new SimpleCalculator();
		int value = calculator.calculate("(0+0)-(0-0)");
		assertEquals(value,0);
	}
	@Test
	public void test11(){
		SimpleCalculator calculator = new SimpleCalculator();
		int value = calculator.calculate("(((1 + ((1 + 2) + (2 - 1)) - (1 - 3)) + 1) + 1) + 1");
		assertEquals(value,10);
	}

}
