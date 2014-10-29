import java.util.Arrays;


public class BoundedQueue {
	//create variables for index for enqueue and dequeue
	private int enIndex;
    private int deIndex;
    //create variable for array (queue) and queue count
    private int[] items;
    private int count;
    //constructor allows us to initialize queue with int
    public BoundedQueue(int size) {
        enIndex = 0;
        deIndex = 0;
        items = new int[size];
    }
    //store integer to queue when it is not full; if it is full display error message
    public void enqueue(int newNumber) {
        if (count == items.length){
            System.out.println("Sorry queue size has been maxed out :(");
        }
        items[enIndex] = newNumber;
        if(++enIndex == items.length){
        	enIndex = 0;
        }
        ++count;
    }
    //remove item from the queue if the queue is not empty
    public int dequeue() {
        if (count == 0){
            System.out.println("Your queue is empty!");
        }
        int item = items[deIndex];
        items[deIndex] = 0;
        if(++deIndex == items.length){
        	deIndex = 0;
        }
        --count;
        return item;
    }
    //simply function to print queue items
    @Override
    public String toString() {
        return Arrays.toString(items);
    }
	
	//basic test to see bounded queue functionality
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
