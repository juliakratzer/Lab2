import java.util.*;

public class myArrayList{
	// finals for creating generic myArrayList
	private final int initial = 50;
	private final double growthPolicy = .2;
	private int currentIndex = 0;
	// array to store values of type T
	public Fraction[] myArray;

	/**
	 * constructor with no params
	 * 
	 * @author Mason Beale
	 */
	public myArrayList() {
		myArray = new Fraction[initial];

	}

	/**
	 * constructor with specified length
	 * 
	 * @author Mason Beale
	 * @param arrLength the user wanted array length
	 */
	public myArrayList(int arrLength) {
		myArray = (Fraction[]) new Object[arrLength];
	}

	public myArrayListIterator iterator() {
		return new myArrayListIterator(this);
		
	}
	/**
	 * the number of items in the array
	 * 
	 * @author Mason Beale
	 * @return the length of the array (not including nulls)
	 */
	public int length() {
		return currentIndex + 1;
	}

	/**
	 * a helper method to grow the array by the growth policy
	 * 
	 * @author Mason Beale
	 */
	public void grow() {
		int newLength = (int) (myArray.length + (myArray.length * growthPolicy));
		myArray = Arrays.copyOf(myArray, newLength);
	}

	/**
	 * adds a new item to the end of the array, calling grow if it would be out of
	 * bounds
	 * 
	 * @author Mason Beale
	 * @param input the item to add to the array
	 * @return true when the item is successfully added
	 */
	public boolean add(Fraction input) {
		if (currentIndex == myArray.length) {
			grow();
			add(input);
		} else {
			myArray[currentIndex] = input;
			currentIndex++;
			return true;
		}
		return false;

	}

	/**
	 * removes the first instance of a given item
	 * 
	 * @author Julia Kratzer
	 * @param input the item to be removed
	 * @return the item that was removed
	 */
	public Fraction remove(Fraction input){
		for (int i = 0; i < myArray.length; i++) {
			if (myArray[i].hasSameValue(input)) {
				Fraction removed = myArray[i];
				return removed;
			}
		}
		return input;
	}

	/**
	 * checks to see if a certain item is in the array
	 * 
	 * @author Mason Beale
	 * @param input the item to check for
	 * @return true if the item is contained in the array
	 */
	public boolean contains(Fraction input) {
		for (Fraction item : myArray) {
			if (item != null && item.compareTo(input) == 0) {
				return true;
			}
		}
		return false;

	}

	/**
	 * @author Mason Beale
	 */
	public String toString() {
		return Arrays.toString(myArray);
	}

	public static void main(String[] args) {
		myArrayList arrList = new myArrayList();
		for (int i = 0; i < 49; i++) {
			Fraction frac = new Fraction(i, i + 1);
			arrList.add(frac);
		}
		myArrayListIterator itr = arrList.iterator();
		System.out.println(arrList);
		itr.add(new Fraction(1,1));
		System.out.println(arrList);
		itr.add(new Fraction(2,1));
		System.out.println(arrList);

	}
}
