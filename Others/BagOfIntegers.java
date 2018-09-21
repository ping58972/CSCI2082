package Sep132018;
//Try to solve problem.
//hehe
public class BagOfIntegers implements Cloneable {
	
	private int numberOfItems;
	private int[] items;
	
	public BagOfIntegers() {
		this.items = new int[10];
		this.numberOfItems = 0;
	}
	
	public BagOfIntegers(int initSize) {
		this.items = new int[initSize];
		this.numberOfItems = 0;
	}
	
	public void add(int element) {
		
		if(numberOfItems == items.length) {
			ensureCapacity(numberOfItems * 2 + 1);
		}
		this.items[numberOfItems] = element;
		numberOfItems++;
		
 	}
	
	public void addMany(int...elements) {
		
		if(numberOfItems + elements.length >= items.length)
			ensureCapacity((numberOfItems + elements.length) * 2);
		
		System.arraycopy(elements, 0, items, numberOfItems, 
								elements.length);
		numberOfItems += elements.length;
		
		
		
 	}
	
	private void ensureCapacity(int newSize) {
		int[] biggerArray = new int[newSize];
		
		System.arraycopy(items, 0, biggerArray, 0, items.length);
		items = biggerArray;
		
	}
	
	@Override
	protected BagOfIntegers clone() {
		BagOfIntegers copy = null;
		
		try {
			copy = (BagOfIntegers) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		copy.items = items.clone();
		
		return copy;
	}

	@Override
	public String toString() {
		String elements = "NumberOfItems: " + numberOfItems 
				+"\tItems length: " + items.length + "\n";
		
		for (int i = 0; i < numberOfItems; i++) {
			elements += items[i] + " ";
		}
		
		return elements;
	}
	
	public static void main(String[] args) {
		BagOfIntegers bag = new BagOfIntegers();
		
		BagOfIntegers bagCopy = bag.clone();

		
		for (int i = 0; i < 7; i++) {
			bag.add(i * 3);
		}
		//BagOfIntegers bagCopy = bag.clone();
		System.out.println(bag);

		bagCopy.add(-99);
		bagCopy.addMany(99,45);
		
		System.out.println(bag);
		System.out.println(bagCopy);
		System.out.println(bag);
		
		
	}
	
	

}
