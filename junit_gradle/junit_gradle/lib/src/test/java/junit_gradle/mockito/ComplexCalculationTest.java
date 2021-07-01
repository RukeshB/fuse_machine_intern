package junit_gradle.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) 
class ComplexCalculationTest {

	@Mock
	BasicCalculation basicCalMock;
	
	ComplexCalculation complexCal;
	
	@BeforeEach
	void init()
	{
		complexCal = new ComplexCalculation(basicCalMock);
	}

	@Test
	@DisplayName("calculation1 test with when thenReturn")
	void testCalculate1() {
		assertNotNull(basicCalMock);
		when(basicCalMock.multiply(2, 2)).thenReturn(4);
		when(basicCalMock.add(4, 2)).thenReturn(6);
		assertEquals(6, complexCal.calculate1(2, 2));
	}
	
	@Test
	@DisplayName("calculation2 test with doReturn when try")
	void testCalculate2() {
		assertNotNull(basicCalMock);
		doReturn(4).when(basicCalMock).multiply(2, 2);
		doReturn(5).when(basicCalMock).multiply(1, 5);
		doReturn(9).when(basicCalMock).add(4, 5);
		assertEquals(9, complexCal.calculate2(2, 2, 1, 5));
	}
	
	@Test
	@DisplayName("calculation3 test with when thenThrow")
	void testCalCulation3()
	{
		assertNotNull(basicCalMock);
		when(basicCalMock.multiply(2, 4)).thenReturn(8);
		when(basicCalMock.divide(8, 0)).thenThrow(new ArithmeticException());
		assertThrows(ArithmeticException.class, ()->complexCal.calculate3(2, 4, 0));
	}
	
	@Test
	@DisplayName("calculation3 test with doThrow when try")
	void testCalCulation3Dothrow()
	{
		assertNotNull(basicCalMock);
		when(basicCalMock.multiply(2, 4)).thenReturn(8);
		doThrow(new ArithmeticException()).when(basicCalMock).divide(8, 0);
		assertThrows(ArithmeticException.class, ()->complexCal.calculate3(2, 4, 0));
	}
	
	@Test
	@DisplayName("test mockito verify")
	void testVerify()
	{
		basicCalMock.subtract(5, 1);
		basicCalMock.add(1, 1);
		basicCalMock.add(1, 1);
		
		verify(basicCalMock).subtract(5, 1);
		verify(basicCalMock, times(2)).add(1, 1);
	}
}
