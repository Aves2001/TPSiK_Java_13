package pz_1;

import java.util.Random;
import java.util.Scanner;

public class Main {
	private int min = -100;
	private int max = 100;

	private Scanner scaner;

	public static void main(String[] args) {
		Main prog = new Main();
		prog.run();
	}

	public static boolean isInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void run() {
		int[] array = new int[inputInt("Введіть розмір масива: ",1)];

		int choice = inputInt(String.format(
				"Виберіть спосіб введення данних, в діапазоні [%d | %d]:\n1) рандомно \n2) з клавіатури\n> ", getMin(), getMax()),
				1, 2);
		if (choice == 1) {
			for (int i = 0; i < array.length; i++) {
				array[i] = randInt(getMin(),getMax());
			}
		} else if (choice == 2) {
			for (int i = 0; i < array.length; i++) {
				array[i] = inputInt(String.format("array[%d] = ", i), getMin(), getMax());
			}
		} else {
			choice = -1;
		}

		System.out.println("\n******************************************************************");
		printArray("array", array);

		int minElem = minElem(array);
		int summElem = summElem(array);

		System.out.println("\n1) мінімальний елемент масиву: " + minElem);
		System.out.println(
				"2) сума елементів масиву, розташованих між першим " + "і другим від’ємними елементами: " + summElem);
	}

	public void printArray(String arrayName, int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%s[%d] = %d\n", arrayName, i, array[i]);
		}
	}

	/**
	 * Метод повертає мінімальний елемент масиву
	 *
	 * @param arr масив який передається в метод
	 * @return повернення мінімального елемента масиву
	 */
	public int minElem(int arr[]) {
		int minEl = arr[0];
		for (int el : arr) {
			if (el < minEl) {
				minEl = el;
			}
		}
		return minEl;
	}

	/**
	 * Метод, що обчислює сума елементів масиву, розташованих між першим і другим
	 * від’ємними елементами
	 *
	 * @param arr масив який передається в метод
	 * @return сума елементів масиву, розташованих між першим і другим від’ємними
	 *         елементами
	 */
	public int summElem(int arr[]) {
		int indexMinElem1 = -1;
		int indexMinElem2 = -1;
		int summ = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				if (1 + i < arr.length) {
					indexMinElem1 = 1 + i;
				}
				break;
			}
		}

		if (indexMinElem1 == -1) {
			System.out.println("\n[INFO (2)] Відємних чисел немає");
			return 0;
		}

		for (int i = indexMinElem1; i < arr.length; i++) {
			if (arr[i] < 0) {
				if (i - 1 >= 0) {
					indexMinElem2 = i - 1;
				}
				break;
			}
		}

		if (indexMinElem2 == -1) {
			System.out.println("\n[INFO (2)] Знайдено тільки одне відємне число");
			return 0;
		}

		for (int i = indexMinElem1; i <= indexMinElem2; i++) {
			summ += arr[i];
		}
		return summ;
	}

	public int randInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

	public int inputInt(String message, int min) {
		return inputInt(message, min, Integer.MAX_VALUE);
	}

	public int inputInt(String message, int min, int max) {
		Boolean error;
		int rez = -1;
		do {
			try {
				error = false;
				rez = inputInt(null, message, min, max);
			} catch (Exception e) {
				error = true;
				System.out.println(e.getMessage());
			}
		}while(error);
		return rez;
	}

	public int inputInt(String inputStr, String message, int min, int max) throws Exception {
		scaner = new Scanner(System.in);
		String str;
		int outInt = 0;
		System.out.print(message);
		if(inputStr != null) {
			str = inputStr;
		} else {
			str = scaner.nextLine();
		}
		if (!isInt(str)) {
			throw new NumberFormatException(String.format("\"%s\" має бути цілим числом не більше \"%d\"\n", str, Integer.MAX_VALUE));
		}
		outInt = Integer.parseInt(str);
		if (outInt < min) {
			throw new NumberFormatException(String.format("Вказане число (%d) не може буте меншем за: %d\n", outInt, min));
		} else if (outInt > max) {
			throw new NumberFormatException(String.format("Вказане число (%d) не може буте більшим за: %d\n", outInt, max));
		}
		return outInt;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
}
