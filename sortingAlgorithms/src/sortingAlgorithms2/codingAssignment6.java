package sortingAlgorithms2;

public class codingAssignment6 {
	public static void BubbleSort(int[] numbers) {
		int i,j,temp = 0;
		
		for (i = 0; i < numbers.length - 1; i++) {
			for (j = 0; j < numbers.length - i - 1; j++) {
				 if (numbers[j] > numbers[j+1]) {
			            temp = numbers[j];
			            numbers[j] = numbers[j + 1];
			            numbers[j + 1] = temp;
				 }
			}
		}
	}
	
	public static void SelectionSort(int[] numbers) {
		
		for(int i = 0; i < numbers.length - 1; i++) {
			int indexSmallest = i;
			for(int j = i + 1; j < numbers.length; j++) {
				if(numbers[j] < numbers[indexSmallest]) {
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
			int j = i-1;
			while((j>-1) && (numbers[j] > list)) {
				numbers[j+1] = numbers[j];
				j--;
			}
			numbers[j+1] = list;
		}
	}
	
				
			
	
	

	
	public static void main(String[] args) {
		int numbers[] = {6,9,20,15,13,12};
		
		BubbleSort(numbers);
		for(int i=0; i < numbers.length; i++){  
            System.out.print(numbers[i] + " ");  
		}
		
		System.out.println("\n");
		
		SelectionSort(numbers);
		for(int i=0; i < numbers.length; i++){  
            System.out.print(numbers[i] + " ");  
		}
		
		System.out.println("\n");
		
		InsertionSort(numbers);
		for(int i=0; i < numbers.length; i++){  
            System.out.print(numbers[i] + " ");  
		}
		
	}

	

}

