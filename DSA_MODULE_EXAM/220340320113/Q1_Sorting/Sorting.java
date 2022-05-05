import java.util.Scanner;

public class Sorting {

	static void insertionSort(int[] array) {

		int length = array.length;		

		for(int i = length - 1; i > 0; i--) {

			int key = array[i];

			for(int j = i - 1; j >= 0; j--) {
				if(key < array[j]) {
					array[key] = array[j];
					break;
				}
			}
			display(array);
		}
	}

	static void display(int[] array) {
		for(int x : array) 
			System.out.print(x + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {

		Scanner objSc = new Scanner(System.in);

		System.out.print("Enter the size of array: ");
		int n = objSc.nextInt();

		int[] array = new int[n];

		System.out.print("Enter the numbers in array: ");
		for(int i = 0; i < n; i++) {
			array[i] = objSc.nextInt();
		}

		insertionSort(array);
	}
}