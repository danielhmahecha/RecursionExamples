import java.util.List;
import java.util.ArrayList;

/**
 * Implements the merge sort algorithm for number arrays
 */
public class MergeNumbersArraySorter implements NumbersArraySorter {

	@Override
	public void sort(List<Integer> numbers) {
		// TODO Implement
		mergeSort(numbers,0,numbers.size()-1);
	}
	
	private void mergeSort(List<Integer> numbers, int first, int last) {
		if(first==last) return;
		int m = (first+last)/2;
		mergeSort(numbers,first,m);
		mergeSort(numbers,m+1,last);
		mergeSortedLists(numbers,first,m,last);
	}

	private void mergeSortedLists(List<Integer> numbers,int first, int m, int last) {
		List<Integer> mergedSet =  new ArrayList<>();
		int i=first;
		int j=m+1;
		while (i<=m && j<=last) {
			int a = numbers.get(i);
			int b = numbers.get(j);
			if (a<=b) {
				mergedSet.add(a);
				i++;
			}
			if (b<a) {
				mergedSet.add(b);
				j++;
			}
		}
		
		for(;i<=m;i++) mergedSet.add(numbers.get(i));
		for(;j<=last;j++) mergedSet.add(numbers.get(j));
		for(int k=0;k<mergedSet.size();k++){
			numbers.set(first+k,mergedSet.get(k));
		}
	}
}
