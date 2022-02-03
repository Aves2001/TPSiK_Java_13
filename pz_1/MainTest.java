package pz_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MainTest {
	/**
	 * припустима точність порівнянь
	 */
	public static final double EPS = 1e-6;

	@Test
	public void testMinElem() {
		int[] intArray = new int[] { 3, 4, 5, 1, 5, 7, 5 };
		Main instance = new Main();
		int expResult = 1;
		int result = instance.minElem(intArray);
		System.out.print("testMinElem --> " + expResult + " | " + result + "\n");
		assertEquals(expResult, result, EPS);
	}

	@Test
	public void testSummElem() {
		// є два відємних числа
		int[] intArray = new int[] { 3, 4, -5, 1, 5, -7, 5 };
		Main instance = new Main();
		int expResult = 6;
		int result = instance.summElem(intArray);
		System.out.println("testSummElem --> " + expResult + " | " + result + "\n");
		assertEquals(expResult, result, EPS);
	}

	@Test
	public void testSummElem2() {
		// є одно відємних числа
		int[] intArray = new int[] { 3, 4, 5, 1, 5, -7, 5 };
		Main instance = new Main();
		int expResult = 0;
		int result = instance.summElem(intArray);
		System.out.println("testSummElem --> " + expResult + " | " + result + "\n");
		assertEquals(expResult, result, EPS);
	}

	@Test
	public void testSummElem3() {
		// немає відємних чисел
		int[] intArray = new int[] { 3, 4, 5, 1, 5, 7, 5 };
		Main instance = new Main();
		int expResult = 0;
		int result = instance.summElem(intArray);
		System.out.println("testSummElem --> " + expResult + " | " + result + "\n");
		assertEquals(expResult, result, EPS);
	}

	@Test
	public void testRandInt() {
		Main instance = new Main();
		instance.setMin(-5);
		instance.setMax(5);
		int min = -5;
		int max = 5;
		int[] testArr = new int[20];
		for (int i = 0; i < testArr.length; i++) {
			testArr[i] = instance.randInt(instance.getMin(),instance.getMax());
			assertTrue(testArr[i] >= min && testArr[i] <= max);
		}
		System.out.printf("testRandInt --> [%d / %d] = ",min,max);
		for (int element : testArr) {
			System.out.print(element+" ");
		}
		System.out.println();
	}

	@Test
	public void testRandIntError() {
		Main instance = new Main();
		instance.setMin(1);
		instance.setMax(5);
		int min = 1;
		int max = 5;
		int[] testArr = new int[20];
		try {
			for (int i = 0; i < testArr.length; i++) {
				testArr[i] = instance.randInt(instance.getMin(),instance.getMax());
				assertTrue(testArr[i] >= min && testArr[i] <= max);
			}
		} catch (Exception e) {

		} finally {
			System.out.printf("testRandIntError --> [%d / %d] = ",min,max);
			for (int element : testArr) {
				System.out.print(element+" ");
			}
			System.out.println();
		}
	}

	@Test
	public void testInputInt() {
		Main instance = new Main();
		String inputData = "6";
		int expResult = 6;
		int result = 0;

		try {
			result = instance.inputInt(inputData,"",-100,100);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		System.out.print("testInputInt --> " + expResult + " | " + result + "\n");
		System.out.println();
		assertEquals(expResult, result, EPS);
	}

	@Test
	public void testInputIntErrorNotNumber() {
		Main instance = new Main();
		String inputData = "-23qwed";
		String failMessage = "testInputIntErrorNotNumber --> получилось передати НЕ чило";
		try {
			instance.inputInt(inputData,"",-100,100);
			System.out.println(failMessage);
			fail(failMessage);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void testInputIntErrorOutOfBounds() {
		Main instance = new Main();
		int min = -100;
		int max = 100;
		String inputData1 = "-101";
		String inputData2 = "101";

		try {
			instance.inputInt(inputData1,"",min,max);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			instance.inputInt(inputData2,"",min,max);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
	}
}
