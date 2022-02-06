package pz_2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MainTest {
	public static final double EPS = 1e-6;

	@Test
	public void testSumUnpairedElements() {
		// парні і непарні елементи
		int arr[] = new int[] {
			1, 2, 3, 4, 5, 6
		};
		Main instance = new Main();
		int result = instance.sumUnpairedElements(arr);
		int expResult = 3;
		assertEquals(expResult, result, EPS);
		System.out.print("testSumUnpairedElements (парні і непарні елементи) --> " + expResult + " | " + result + "\n");
	}
	
	@Test
	public void testSumUnpairedElements2() {
		//всі елементи непарні
		int arr[] = new int[] {
			1, 3, 5, 7
		};
		Main instance = new Main();
		int result = instance.sumUnpairedElements(arr);
		int expResult = arr.length;
		assertEquals(expResult, result, EPS);
		System.out.print("testSumUnpairedElements2 (всі елементи непарні) --> " + expResult + " | " + result + "\n");
	}

	@Test
	public void testSumUnpairedElements3() {
		//всі елементи парні
		int arr[] = new int[] {
			2, 4, 6, 8
		};
		Main instance = new Main();
		int result = instance.sumUnpairedElements(arr);
		int expResult = 0;
		assertEquals(expResult, result, EPS);
		System.out.print("testSumUnpairedElements3 (всі елементи парні) --> " + expResult + " | " + result + "\n");
	}

	@Test
	public void testSumUnpairedElementsLength0() {
		int arr[] = new int[0];
		Main instance = new Main();
		int result = instance.sumUnpairedElements(arr);
		int expResult = 0;
		assertEquals(expResult, result, EPS);
		System.out.print("testSumUnpairedElementsLength0 (масив порожній) --> " + expResult + " | " + result + "\n");
	}

	@Test
	public void testSumUnpairedElementsNull() {
		int arr[] = null;
		Main instance = new Main();
		try {
			instance.sumUnpairedElements(arr);
			fail();
		} catch (Exception e) {
		}
	}

	//***********************************************************************//

	@Test
	public void testRandInt() {
		Main instance = new Main();
		int min = 1;
		int max = 3;
		int[] testArr = new int[20];
		try {
			for (int i = 0; i < testArr.length; i++) {
				testArr[i] = instance.randInt(min,max);
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
			fail("--> testInputInt --> "+e.getMessage());
		}
		System.out.print("testInputInt --> " + expResult + " | " + result+"\n");
		assertEquals(expResult, result, EPS);
	}

	@Test
	public void testInputIntErrorNotNumber() {
		Main instance = new Main();
		String inputData = "-23qwed";
		String failMessage = "--> testInputIntErrorNotNumber --> получилось передати НЕ чило";
		try {
			instance.inputInt(inputData,"",-100,100);
			System.out.println(failMessage);
			fail(failMessage);
		} catch (Exception e) {
			System.out.println("testInputIntErrorNotNumber --> НЕ получилось передати, НЕ чило");
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
			System.out.println("--> testInputIntErrorOutOfBounds --> ВДАЛОСЬ вийти за нижню границю");
			fail();
		} catch (Exception e) {
			System.out.println("testInputIntErrorOutOfBounds --> НЕ вдалось вийти за нижню границю");
			assertTrue(true);
		}
		try {
			instance.inputInt(inputData2,"",min,max);
			System.out.println("--> testInputIntErrorOutOfBounds --> ВДАЛОСЬ вийти за верхню границю");
			fail();
		} catch (Exception e) {
			System.out.println("testInputIntErrorOutOfBounds --> НЕ вдалось вийти за верхню границю");
			assertTrue(true);
		}

	}
}