package pz_2;

import java.util.Random;
import java.util.Scanner;

public class Main {
	private Scanner scaner;

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
	
	public void run() {
		int[] array = new int[inputInt("Введіть розмір масива: ",1)];

		int choice = inputInt(String.format(
				"Виберіть спосіб введення данних:\n1) рандомно \n2) з клавіатури\n> "),
				1, 2);
		if (choice == 1) {
			for (int i = 0; i < array.length; i++) {
				array[i] = randInt(-100,100);
			}
		} else if (choice == 2) {
			for (int i = 0; i < array.length; i++) {
				array[i] = inputInt(String.format("array[%d] = ", i));
			}
		} 

		System.out.println("\n******************************************************************");
		printArray("array", array);
		
		int sumUnpairedElements = sumUnpairedElements(array);
		System.out.printf("\nКількість непарних елементів в одновимірному масиві: %d\n",sumUnpairedElements);
	}
	
	public int sumUnpairedElements(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] %2 != 0 ) {
				sum+=1;
			}
		}
		return sum;
	}
	
	public void printArray(String arrayName, int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%s[%d] = %d\n", arrayName, i, array[i]);
		}
	}
	
	public int randInt(int min, int max) {
		Random random = new Random();
		return random.nextInt((max+1)  - min) + min;
	}
	
	public boolean isInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public int inputInt(String message) {
		return inputInt(message, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
			throw new NumberFormatException(String.format("\"%s\" має бути цілим числом, в діапазоні: [%d | %d]\n", str, Integer.MIN_VALUE,Integer.MAX_VALUE));
		}
		outInt = Integer.parseInt(str);
		if (outInt < min) {
			throw new NumberFormatException(String.format("Вказане число (%d) не може буте меншем за: %d\n", outInt, min));
		} else if (outInt > max) {
			throw new NumberFormatException(String.format("Вказане число (%d) не може буте більшим за: %d\n", outInt, max));
		}
		return outInt;
	}
}
