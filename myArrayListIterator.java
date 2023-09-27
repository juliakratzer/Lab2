import java.util.*;

public class myArrayListIterator implements Iterator<Fraction>{
	private int previousIndex;
	private int nextIndex = 0;
	private myArrayList arr;
	
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
		return null;
	}
	
	public int nextIndex() {
		return 0;
	}
	
	public Fraction previous() {
		return null;
	}
	
	public int previousIndex() {
		return 0;
	}
	
	public void remove() {
	}
	
	public void set(Fraction frac) {
	}
}
