package junit_gradle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

class CalculationTest {
	private Calculation cal;
	
	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter)
	{
		cal = new Calculation();
		testReporter.publishEntry("Running "+testInfo.getTestMethod().get()+" Method with Tag "+testInfo.getTags());
	}
	
	@Test
	@DisplayName("Testing add method")
	@Tag("basicMath")
	void testAdd() {
		int expected = 2;
		int actual = cal.add(1, 1);
		
		assertEquals(expected, actual,"add methode add two number");
	}

	@Test
	@Tag("basicMath")
	void testDivide()
	{
		//fail test
		//assertThrows(NullPointerException.class,()-> cal.divide(1, 0));
		
		//sccuess test
		assertThrows(ArithmeticException.class,()-> cal.divide(1, 0));
	}
	
	@Test
	@DisplayName("test multiply method")
	@Tag("basicMath")
	void testMultiply()
	{
		assertAll(
				()->assertEquals(4, cal.multiply(2, 2)),
				()->assertEquals(0, cal.multiply(0, 2)),
				()->assertEquals(-10, cal.multiply(2, -5))
				);
	}
	
	@Test
	@Tag("geometric")
	void testAreaOfCircle() 
	{
		double expected = 314.1592653589793;
		double actual = cal.areaOfCircle(10);
		
		assertEquals(expected, actual,"return area of circle");
	}
	
	@Test
	@Disabled
	void testDisable()
	{
		fail("this test is not complete");
	}
}
