package junit_gradle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculationTest {
	private Calculation cal = new Calculation();
	@Test
	void test() {
		int expected = 2;
		int actual = cal.addnumber(1, 1);
		
		assertEquals(expected, actual);
	}

	@Test
	void test2() {
		int expected = 3;
		int actual = cal.addnumber(1, 1);
		
		assertEquals(expected, actual);
	}
}
