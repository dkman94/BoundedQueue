import java.util.Arrays;


public class BoundedQueue {
	private int enqueueIndex;// Separate index to ensure enqueue happens at the end
    private int dequeueIndex;// Separate index to ensure dequeue happens at the
                            // start
    private int[] items;
    private int count;
    // Lazy to add javadocs please provide
    public BoundedQueue(int size) {
        enqueueIndex = 0;
        dequeueIndex = 0;
        items = new int[size];
    }
    // Lazy to add javadocs please provide
    public void enqueue(int newNumber) {
        if (count == items.length){
            System.out.println("Sorry queue size has been maxed out :(");
        }
        items[enqueueIndex] = newNumber;
        if(++enqueueIndex == items.length){
        	enqueueIndex = 0;
        }
        ++count;
    }
    // Lazy to add javadocs please provide
    public int dequeue() {
        if (count == 0)
            throw new IllegalStateException();
        int item = items[dequeueIndex];
        items[dequeueIndex] = 0;
        if(++dequeueIndex == items.length){
        	dequeueIndex = 0;
        }
        --count;
        return item;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
	
	
	public static void main(String[] args){
		System.out.println("Here's your Bounded Queue:");
		BoundedQueue test = new BoundedQueue(5);
		test.enqueue(4);
		test.enqueue(5);
		test.enqueue(3);
		System.out.println(test.toString());
		test.dequeue();
		System.out.println(test.toString());
		test.dequeue();
		System.out.println(test.toString());
		test.enqueue(2);
		test.enqueue(2);
		test.enqueue(2);
		System.out.println(test.toString());
		test.enqueue(2);
		System.out.println(test.toString());
		test.enqueue(2);
	}
}
