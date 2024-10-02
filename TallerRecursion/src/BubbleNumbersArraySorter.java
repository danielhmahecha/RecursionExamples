import java.util.List;

/**
 * Implements the bubble sort algorithm for number arrays
 */
public class BubbleNumbersArraySorter implements NumbersArraySorter {

	@Override
	public void sort(List<Integer> numbers) {
		// TODO Implement
		bubbleSort(numbers,0,numbers.size()-1);
	}
	
	private void bubbleSort(List<Integer> numbers, int first, int last) {
		int i;
		int j;
		for (i=first;i<last-1;i++) {
			for (j=first;j<last-i;j++) {
				int a=numbers.get(j);
				int b=numbers.get(j+1);
				if(a>b) {
					numbers.set(j, b);
					numbers.set(j+1, a);
				}
			}
			
		}
	
	}

}
