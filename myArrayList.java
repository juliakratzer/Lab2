import java.util.*;

public class myArrayList {
	// finals for creating generic myArrayList
	private final int initial = 50;
	private final double growthPolicy = .2;
	private int currentIndex = 0;
	// array to store values of type T
	private Fraction[] myArray;

	/**
	 * constructor with no params
	 * @author Mason Beale
	 */
	public myArrayList() {
		myArray = new Fraction[initial];

	}

	/**
	 * constructor with specified length
	 * @author Mason Beale
	 * @param arrLength the user wanted array length
	 */
	public myArrayList(int arrLength) {
		myArray = (Fraction[]) new Object[arrLength];
	}

	/**
	 * the number of items in the array
	 * @author Mason Beale
	 * @return the length of the array (not including nulls)
	 */
	public int length() {
		return currentIndex + 1;
	}

	/**
	 * a helper method to grow the array by the growth policy
	 * @author Mason Beale
	 */
	private void grow() {
		int newLength = (int) (myArray.length + (myArray.length * growthPolicy));
		myArray = Arrays.copyOf(myArray, newLength);
	}

	/**
	 * adds a new item to the end of the array, calling grow if it would be out of bounds
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
	 * @author Mason Beale
	 * @param input the item to be removed
	 * @return the item that was removed
	 */
// 	public Fraction remove(Fraction input) {
// 		for (int i = 0; i < myArray.length; i++) {

// 			if (myArray[i].compareTo(input) == 0) {
// 				for (int j = i; j < myArray.length - 1; j++) {
// 					myArray[j] = myArray[j + 1];
// 				}
// 				myArray[myArray.length - 1] = null;
// 				currentIndex--;
// 				return input;
// 			}
// 		}
// 		return new Fraction(0, 0);

// 	}

  	/**
	 * removes the first instance of a given item
	 * @author Julia Kratzer 
	 * @param input the item to be removed
	 * @return the item that was removed
	 */
  	public Fraction remove (Fraction input); {
	  for (int i = 0; i < myArray.length; i++) {
        	if (elements[i].hasSameValue(input)) {
            		Fraction removed = elements[I];
        	}
        	return removed;
	  }
 	}
	/**
	 * checks to see if a certain item is in the array
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
		for (int i = 0; i < 51; i++) {
			Fraction frac = new Fraction(i, i + 1);
			arrList.add(frac);
		}
		System.out.println("the original myArrayList:");
		System.out.println(arrList.toString());

		System.out.println("removing the fraction 0/1 and adding 285/285:");
		arrList.remove(new Fraction(0, 1));
		arrList.add(new Fraction(285, 285));
		System.out.println(arrList.toString());
		System.out.println("checking to see if the myArrayList contains 0/1:");
		System.out.println(arrList.contains(new Fraction(0, 1)));

	}
}
