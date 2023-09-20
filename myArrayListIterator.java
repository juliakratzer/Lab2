
public interface myArrayListIterator {
	
	public void add(Fraction frac);
	
	public boolean hasNext();
	
	public boolean hasPrevious();
	
	public Fraction next();
	
	public int nextIndex();
	
	public Fraction previous();
	
	public int previousIndex();
	
	public void remove();
	
	public void set(Fraction frac);
}
