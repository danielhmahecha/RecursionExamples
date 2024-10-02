import java.util.ArrayList;

public class DivideAndConquerIntegerArrays {

	// Array of numbers
	private ArrayList<Integer> numbers;

	/**
	 * Creates a new object with the given numbers
	 * @param numbers
	 */
	public DivideAndConquerIntegerArrays(ArrayList<Integer> numbers) {
		this.numbers = numbers;
	}
	
	/**
	 * Calculates the maximum value in this list
	 * @return int Maximum value in the list
	 */
	public int max() {
		//TODO: implementar en una linea utilizando el siguiente metodo
			// TODO: Implementar con un algoritmo recursivo
		if(numbers.isEmpty()) throw new ArrayIndexOutOfBoundsException("Max can not be used on an empty array");
		return max(0,numbers.size()-1);
		}
	
	/**
	 * Calculates the maximum value within the given indexes
	 * @param first index
	 * @param last index
	 * @return int maximum value within the given limits
	 */
	private int max(int first, int last ) {
		//TODO: Implementar utilizando la tecnica de dividir y conquistar
		if(first==last) {
			return numbers.get(first);
		}
		int m = (first+last)/2;
		int left=max(first,m);
		int right=max(m+1,last);
		if (left>=right) {
			return left;
		}
		else return right;
		}
	/**
	 * Finds a position in this numbers where the given value is located
	 * @param value to search
	 * @return int position where the given value is located
	 */
	public int searchUnsorted (int value) {
		//TODO: implementar en una linea utilizando el siguiente metodo
		if(numbers.isEmpty()) throw new ArrayIndexOutOfBoundsException("Search Unsorted can not be used on an empty array");
		return searchUnsorted(value,0,numbers.size()-1);
		
	}
	/**
	 * Finds a position in this numbers between the given limits where the given value is located
	 * @param value to search
	 * @param first index
	 * @param last index
	 * @return int position between first and last where the given value is located
	 */
	private int searchUnsorted (int value, int first, int last) {
		//TODO: Implementar utilizando la tecnica de dividir y conquistar
		int position=-1;
		if (first==last) {
			if (numbers.get(first)==value) return first;
			else return position;
			}
		int mid=(first+last)/2;
		int left=searchUnsorted(value,first,mid);
		int right=searchUnsorted(value,mid+1,last);
		if (left!=-1) position=left;
		else if (right!=-1) position=right;
		return position; 
	}
	/**
	 * Finds a position in this numbers where the given value is located
	 * PRE: the numbers are sorted
	 * @param value to search
	 * @return int position where the given value is located
	 */
	public int searchSorted (int value) {
		//TODO: implementar en una linea utilizando el siguiente metodo
		if(numbers.isEmpty()) throw new ArrayIndexOutOfBoundsException("Search Sorted can not be used on an empty array");
		return searchSorted(value,0,numbers.size()-1);
	}
	/**
	 * Finds a position in this numbers between the given limits where the given value is located
	 * PRE: the numbers are sorted
	 * @param value to search
	 * @param first index
	 * @param last index
	 * @return int position between first and last where the given value is located
	 */
	private int searchSorted (int value, int first, int last) {
		//TODO: Implementar busqueda binaria
		if (first==last) {
			if (numbers.get(first)==value) return first;
			else return -1;
			}
		int m=(first+last)/2;
		int number = numbers.get(m);
		if (number==value) return m;
		if (number<value) {
			searchSorted(value,first,m);
		}
		if (number>value) {
			searchSorted(value,m+1,last);
		}
		return -1;
	}
	
	/**
	 * Counts the number of even elements in this list of numbers
	 * @return int Number of values that are even
	 */
	public int countEven() {
		//TODO: implementar en una linea utilizando el siguiente metodo
		if(numbers.isEmpty()) throw new ArrayIndexOutOfBoundsException("Count Even can not be used on an empty array");
		return countEven(0,numbers.size()-1);
	}
	
	/**
	 * Counts the number of even elements in this list of numbers between the given limits
	 * @param first index
	 * @param last index
	 * @return int count of even values within the given limits
	 */
	private int countEven (int first, int last) {
		//TODO: Implementar utilizando la tecnica de dividir y conquistar
		if (first==last) {
			if (numbers.get(first)%2==0) return 1;
			else return 0;
		}
		int m=(first+last)/2;
		int left=countEven(first,m);
		int right=countEven(m+1,last);
		return left+right;
	}
}
