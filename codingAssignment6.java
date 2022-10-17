package sortingAlgorithms2;

public class codingAssignment6 {
	public static void BubbleSort(int[] numbers) {
		int i, j, temp = 0;

		for (i = 0; i < numbers.length - 1; i++) {
			for (j = 0; j < numbers.length - i - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
	}

	public static void SelectionSort(int[] numbers) {

		for (int i = 0; i < numbers.length - 1; i++) {
			int indexSmallest = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] < numbers[indexSmallest]) {
					indexSmallest = j;
				}
			}
			int temp = numbers[i];
			numbers[i] = numbers[indexSmallest];
			numbers[indexSmallest] = temp;

		}

	}

	public static void InsertionSort(int[] numbers) {

		int n = numbers.length;

		for (int i = 0; i < n; i++) {
			int list = numbers[i];
			int j = i - 1;
			while ((j > -1) && (numbers[j] > list)) {
				numbers[j + 1] = numbers[j];
				j--;
			}
			numbers[j + 1] = list;
		}
	}

	public static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			if (i % 100 == 0) {
				System.out.println();
			}
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}

	public static void insertionSortInterleaved(int[] numbers, int startIndex, int gap) {
		for (int i = startIndex + gap; i < numbers.length; i += gap) {
			int j = i;
			while (j - gap >= startIndex && numbers[j] < numbers[j - gap]) {
				// Swap numbers[j] and numbers [j - gap]
				int temp = numbers[j];
				numbers[j] = numbers[j - gap];
				numbers[j - gap] = temp;
				j -= gap;
			}
		}
	}

	public static void shellSort(int[] numbers, int[] gapValues) {
		for (int g = 0; g < gapValues.length; g++) {
			for (int i = 0; i < gapValues[g]; i++) {
				insertionSortInterleaved(numbers, i, gapValues[g]);
			}
		}
	}

	public static int partition(int[] numbers, int startIndex, int endIndex) {
		// Select the middle value as the pivot.
		int midpoint = startIndex + (endIndex - startIndex) / 2;
		int pivot = numbers[midpoint];

		// "low" and "high" start at the ends of the array segment
		// and move towards each other.
		int low = startIndex;
		int high = endIndex;

		boolean done = false;
		while (!done) {
			// Increment low while numbers[low] < pivot
			while (numbers[low] < pivot) {
				low = low + 1;
			}

			// Decrement high while pivot < numbers[high]
			while (pivot < numbers[high]) {
				high = high - 1;
			}

			// If low and high have crossed each other, the loop
			// is done. If not, the elements are swapped, low is
			// incremented and high is decremented.
			if (low >= high) {
				done = true;
			} else {
				int temp = numbers[low];
				numbers[low] = numbers[high];
				numbers[high] = temp;
				low++;
				high--;
			}
		}

		// "high" is the last index in the left segment.
		return high;
	}

	public static void quicksort(int[] numbers, int startIndex, int endIndex) {
		// Only attempt to sort the array segment if there are
		// at least 2 elements
		if (endIndex <= startIndex) {
			return;
		}

		// Partition the array segment
		int high = partition(numbers, startIndex, endIndex);

		// Recursively sort the left segment
		quicksort(numbers, startIndex, high);

		// Recursively sort the right segment
		quicksort(numbers, high + 1, endIndex);
	}

	public static void main(String[] args) {
		int numbers[] = new int[10000];
		int numbers2[] = new int[10000];
		int numbers3[] = new int[10000];
		int numbers4[] = new int[10000];
		int numbers5[] = new int[10000];
		
		int gapValues[] = {500, 400, 250, 100, 5, 1};

		for (int i = 0; i < 10000; i++) {
			numbers[i] = (int) ((Math.random() * 10));
		}

		for (int i = 0; i < 10000; i++) {
			numbers2[i] = (int) ((Math.random() * 10));
		}

		for (int i = 0; i < 10000; i++) {
			numbers3[i] = (int) ((Math.random() * 10));
		}

		for (int i = 0; i < 10000; i++) {
			numbers4[i] = (int) ((Math.random() * 10));
		}

		for (int i = 0; i < 10000; i++) {
			numbers5[i] = (int) ((Math.random() * 10));
		}

		quicksort(numbers, 0, numbers.length - 1);
		printArray(numbers);

		BubbleSort(numbers2);
		printArray(numbers2);

		SelectionSort(numbers3);
		printArray(numbers3);

		InsertionSort(numbers4);
		printArray(numbers4);
		
		shellSort(numbers5, gapValues);
		printArray(numbers5);

	}

}
