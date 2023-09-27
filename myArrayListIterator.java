import java.util.*;

public class myArrayListIterator implements Iterator<Fraction>{
	private int previousIndex;
	private int nextIndex = 0;
	private myArrayList arr;
	private boolean nextWasLast;
	
	
	public myArrayListIterator(myArrayList arrList) {
		arr = arrList;
	}
	
	
	public void add(Fraction frac) {
		Fraction stored = frac;

		if(arr.myArray[arr.myArray.length-1] != null) {
			arr.grow();
		}
		for(int i = nextIndex; i<arr.myArray.length;i++) {
//			System.out.println(i);
//			System.out.println(arr.myArray.length);
			Fraction keep = arr.myArray[i];
			arr.myArray[i] = stored;
			stored = keep;
			
		}
		
	}
	
	public boolean hasNext() {
		if(nextIndex<arr.length()) {
			return true;
		}
		return false;
	}
	
	public boolean hasPrevious() {
		if(previousIndex>=0) {
			return true;
		}
		return false;
	}
	
	public Fraction next() {
		nextWasLast = true;
		return null;
	}
	
	public int nextIndex() {
		return 0;
	}
	
	public Fraction previous() {
		nextWasLast = false;
		return null;
	}
	
	/**
	 * returns the index of the item that will be returned by the next call to previous
	 * @author JoveEUSM
	 * 
	 * 
	 * @return the index of the item returned by the next call to previous(). if there would be no item it returns -1
	 */
	public int previousIndex() {
		if(previousIndex>-1) {
			return previousIndex; 
		}
		return -1;
	}
	
	/**
	 * removes the last item returned by a call to either next previous, whichever was more recent
	 * @author JoveEUSM 
	 * 
	 */
	public void remove() {
		if(nextWasLast) {
			arr.remove(arr.myArray[nextIndex]);
		}
		arr.remove(arr.myArray[lastIndex]);
	}
	
	public void set(Fraction frac) {
	}
}
