/**
 * Implementation of a linked list with recursive methods
 */
public class RecursiveIntegerLinkedList {

	//Number in this position of the list
	private int number;
	//Tells if this object represents an empty list
	private boolean empty;
	//Next element of the list. null if this is the last element of a list
	private RecursiveIntegerLinkedList next;
	//Last element of the list. It should only be used by the head of a list in the add method
	private RecursiveIntegerLinkedList last;
	
	/**
	 * Creates an empty list
	 */
	public RecursiveIntegerLinkedList () {
		next = last = null;
		empty = true;
	}
	/**
	 * Creates a list with the given value
	 * @param value to be added to the list
	 */
	public RecursiveIntegerLinkedList (int value) {
		number = value;
		next = null;
		last = this;
		empty = false;
	}
	/**
	 * Adds the value at the end of the current list
	 * @param value to be added at the end
	 */
	public void add (int value) {
		if(empty) {
			number = value;
			last = this;
			empty= false;
		} else {
			RecursiveIntegerLinkedList newLast = new RecursiveIntegerLinkedList(value);
			last.next = newLast;
			last = newLast;
		}
	}
	
	/**
	 * Returns the element in the current position of the list
	 * @param pos position in the list
	 * @return int the value present at the given position.
	 * @throws ArrayIndexOutOfBoundsException if the given position is invalid
	 */
	public int get (int pos) {
		if(empty) throw new ArrayIndexOutOfBoundsException("Get can not be used on an empty list");
		if(next == null) throw new ArrayIndexOutOfBoundsException("Invalid argument for get: "+pos);
		if(pos ==0) return number;
		return next.get(pos-1);
	}
	/**
	 * Calculates the size of the list
	 * @return int Size of the list
	 */
	public int size () {
		// TODO: Implementar con un algoritmo recursivo;
		if (empty) return 0;
		if (next==null) return 1;
		return next.size()+1;
	}
	/**
	 * Returns the index of the first appearance of the given value
	 * @param value to be searched
	 * @return int position of the list whare the value is located
	 */
	public int indexOf(int value) {
		// TODO: Implementar con un algoritmo recursivo
		if(empty) throw new ArrayIndexOutOfBoundsException("Index Of can not be used on an empty list");
		int size=size();
		return hasValue(value,size);
	}
	
	/**
	 * Allows to calculate the index of the first appearance of the given value
	 * @param value to be searched and size of the number list
	 * @return int position of the list where the value is located
	 */
	private int hasValue(int value, int size) {
		if (next==null) {
			if (number==value) {
				return size-size();
			}
			return -1;
		}
		if (number==value) return size-size();
		return next.hasValue(value,size);
	}
		
	/**
	 * Returns the index of the last appearance of the given value
	 * @param value to be searched
	 * @return int position of the list whare the value is located
	 */
	public int lastIndexOf(int value) {
		// TODO: Implementar con un algoritmo recursivo
		if(empty) throw new ArrayIndexOutOfBoundsException("Last Index Of can not be used on an empty list");
		int size=size();
		int max=-1;
		return hasLastValue(value,size,max);
	}
	
	/**
	 * Allows to calculate the index of the last appearance of the given value
	 * @param value to be searched, size of number list, -1 as default position of value
	 * @return int last position of the list where the value is located
	 */
	private int hasLastValue(int value, int size, int max) {
		if (next==null) {
			if (number==value) {
				max=size-size();
			}
			return max;
		}
		if (number==value) {
			max=size-size();
			}
		return next.hasLastValue(value,size,max);
	}
	
	/**
	 * Calculates the maximum value in the list
	 * @return int Maximum value
	 */
	public int max () {
		// TODO: Implementar con un algoritmo recursivo
		if(empty) throw new ArrayIndexOutOfBoundsException("Max can not be used on an empty list");
		int max=Integer.MIN_VALUE;
		return hasMax(max);
	}
	/**
	 * Allows to calculate the maximum value in the list
	 * @param -1 as default position of maximum value
	 * @return int Maximum value
	 */
	private int hasMax(int max) {
		if (next==null) {
			if(max<number) {
				max=number;
				}
			return max;
			}
		if (max<number) {
			return next.hasMax(number);
		}
		return next.hasMax(max);
	}
	/**
	 * Counts the number of even elements in the list
	 * @return int Number of values that are even
	 */
	public int countEven () {
		// TODO: Implementar con un algoritmo recursivo
		if(next==null) {
			if (number%2==0) {
				return 1;
			}
			else return 0;
		}
		if(number%2==0) {
			return next.countEven()+1;
		}
		return next.countEven();
	}
			
	/**
	 * Tells if the list is sorted
	 * @return boolean if the list is sorted by value. False otherwise
	 */
	public boolean isSorted () {
		// TODO: Implementar con un algoritmo recursivo
		if(empty) throw new ArrayIndexOutOfBoundsException("Is Sorted can not be used on an empty list");
		if (next==null) return true;
		if (number>next.number) {
			return false;
		}
		return next.isSorted();
	}
}
