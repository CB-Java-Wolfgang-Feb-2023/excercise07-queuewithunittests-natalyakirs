package HW7;

public class QueueToTests {

    private int SIZE = 3;
    private int[] queue1 = new int[SIZE];
    private int front = -1;
    private int rear = -1;

    //Check the size of the queue1
    public int size() {
        return rear - front + 1;
    }


    // check if the queue1 is full
    public boolean isFull() {
        if(rear == SIZE - 1){
            return true;
        }
        return false;
    }

    // check if the queue1 is empty
    public boolean isEmpty() {
        if(front == -1){
            return true;
        }
        return false;
    }

    // insert elements to the queue1
    public void enqueue(int element) {
        // first to check if the queue1 is full already
        if(isFull()) {
            throw new IllegalArgumentException("Queue is already full, you can't insert an element " + element);
        } else {
            front = 0;
            rear++;
            queue1[rear] = element;
            System.out.println("The element " + element + " was inserted into queue1.");
        }
    }

    // delete element from the queue1
    public int dequeue() {
        int element ;
        // first to check if the queue1 is empty
        if (isEmpty()) {
            throw new IllegalArgumentException ("Queue is empty, you can't delete an element.");
        } else {
            //delete first element in queue1
            element = queue1[front];
            // If queue1 consists of only one element - return original values to front and rear
            if(rear == front) {
                front = -1;
                rear = -1;
            } else {
                // Last case with queue1 consisting of more than 1 element
                front++;
            }
            System.out.println("The element " + element + " was deleted from the queue1");
            return element;
        }
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    @Override
    public String toString() {
        return "MyQueue{}";
    }

}
