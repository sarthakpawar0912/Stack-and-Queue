

public class CustomQueue { // Declares a public class named CustomQueue for queue implementation

    private int[] data; // Array to store queue elements, private to encapsulate data
    private static final int DEFAULT_SIZE = 10; // Constant for default queue size, private, static, and final
    int end = 0; // Tracks the rear of the queue (number of elements), initialized to 0 (empty queue)

    // Constructor for default queue size
    public CustomQueue() { // Defines the no-arg constructor
        this(DEFAULT_SIZE); // Delegates to parameterized constructor with DEFAULT_SIZE (10)
    } // Summary: Creates a queue with default size 10, reusing the parameterized constructor for initialization.

    // Constructor for custom queue size
    public CustomQueue(int size) { // Defines constructor with size parameter
        this.data = new int[size]; // Initializes data array with specified size, elements default to 0
    } // Summary: Creates a queue with user-defined size, allocating memory for the array.

    // Checks if the queue is full
    private boolean isFull() { // Private method to check if queue has reached capacity
        return end == data.length; // Returns true if end equals array length (no more space), false otherwise
    } // Summary: Determines if the queue is full by checking if end has reached the array’s capacity, used to prevent overflow.

    // Checks if the queue is empty
    private boolean isEmpty() { // Private method to check if queue has no elements
        return end == 0; // Returns true if end is 0 (no elements), false otherwise
    } // Summary: Checks if the queue is empty by verifying if end is at its initial value, used to prevent underflow.

    // Inserts an item at the rear of the queue
    public boolean insert(int item) { // Method to add item to queue’s rear, returns boolean for success
        if (isFull()) { // Checks if queue is full
            System.out.println("Queue is Full"); // Prints error message if no space
            return false; // Returns false to indicate insertion failure
        } // If queue is full, execution stops here

        data[end++] = item; // Stores item at rear index and increments end
        return true; // Returns true to confirm successful insertion
    } // Summary: Adds an item to the queue’s rear if there’s space, updating end. Returns false with a message if full.

    // Removes and returns the front item
    public int remove() throws Exception { // Method to remove front item, may throw exception
        if (isEmpty()) { // Checks if queue is empty
            throw new Exception("Cannot REMOVE From an Empty Queue..!!"); // Throws exception if empty
        } // If empty, execution stops here

        int removed = data[0]; // Stores front item (index 0) for return

        for (int i = 1; i < end; i++) { // Loops from second element to end
            data[i - 1] = data[i]; // Shifts each element one position left
        } // After loop, all elements are shifted left by one

        end--; // Decrements end to reflect new queue size
        return removed; // Returns the removed front item
    } // Summary: Removes and returns the front item, shifts all elements left, and updates end. Throws exception for empty queue.

    // Returns the front item without removing it
    public int front() throws Exception { // Method to view front item, may throw exception
        if (isEmpty()) { // Checks if queue is empty
            throw new Exception("Empty QUEUE..!!"); // Throws exception if empty
        } // If empty, execution stops here
        return data[0]; // Returns front item (index 0) without modification
    } // Summary: Returns the front item without altering the queue, throwing an exception if empty.

    // Main function to test the CustomQueue implementation
    public static void main(String[] args) { // Entry point for testing queue operations
        try { // Wraps tests in try-catch to handle exceptions
            // Test Case 1: Default queue (size = 10)
            System.out.println("Test Case 1: Default Queue (size = 10)"); // Prints test case header
            CustomQueue queue1 = new CustomQueue(); // Creates queue with default size
            System.out.println("Is empty? " + queue1.isEmpty()); // Checks if empty (expected: true)

            // Insert elements
            System.out.println("Inserting 10, 20, 30, 40, 50"); // Announces insertions
            queue1.insert(10); // Inserts 10, end = 1, data[0] = 10
            queue1.insert(20); // Inserts 20, end = 2, data[1] = 20
            queue1.insert(30); // Inserts 30, end = 3, data[2] = 30
            queue1.insert(40); // Inserts 40, end = 4, data[3] = 40
            queue1.insert(50); // Inserts 50, end = 5, data[4] = 50
            System.out.println("Is empty? " + queue1.isEmpty()); // Checks empty (expected: false)
            System.out.println("Is full? " + queue1.isFull()); // Checks full (expected: false)

            // Front and remove
            System.out.println("Front: " + queue1.front()); // Views front (expected: 10)
            System.out.println("Remove: " + queue1.remove()); // Removes front (expected: 10)
            System.out.println("Remove: " + queue1.remove()); // Removes next (expected: 20)
            System.out.println("Front: " + queue1.front()); // Views new front (expected: 30)

            // Fill queue
            System.out.println("Inserting 60, 70, 80, 90, 100, 110"); // Announces more insertions
            queue1.insert(60); // end = 4
            queue1.insert(70); // end = 5
            queue1.insert(80); // end = 6
            queue1.insert(90); // end = 7
            queue1.insert(100); // end = 8
            queue1.insert(110); // end = 9
            System.out.println("Is full? " + queue1.isFull()); // Checks full (expected: true)
            queue1.insert(120); // Attempts insert (expected: Queue is Full, false)

            // Test Case 2: Custom size (3)
            System.out.println("\nTest Case 2: Custom Queue (size = 3)"); // Test case header
            CustomQueue queue2 = new CustomQueue(3); // Creates queue with size 3
            System.out.println("Is empty? " + queue2.isEmpty()); // Checks empty (expected: true)

            // Insert elements
            System.out.println("Inserting 100, 200, 300, 400"); // Announces insertions
            queue2.insert(100); // end = 1
            queue2.insert(200); // end = 2
            queue2.insert(300); // end = 3
            queue2.insert(400); // Expected: Queue is Full, false
            System.out.println("Is full? " + queue2.isFull()); // Checks full (expected: true)

            // Front and remove
            System.out.println("Front: " + queue2.front()); // Expected: 100
            System.out.println("Remove: " + queue2.remove()); // Expected: 100
            System.out.println("Remove: " + queue2.remove()); // Expected: 200
            System.out.println("Remove: " + queue2.remove()); // Expected: 300
            System.out.println("Is empty? " + queue2.isEmpty()); // Expected: true

            // Test Case 3: Edge cases (empty queue)
            System.out.println("\nTest Case 3: Edge Cases"); // Test case header
            CustomQueue queue3 = new CustomQueue(2); // Creates queue with size 2
            System.out.println("Trying to remove from empty queue"); // Announces remove attempt
            try { // Wraps remove in try-catch
                queue3.remove(); // Expected: throws exception
            } catch (Exception e) { // Catches exception
                System.out.println("Exception: " + e.getMessage()); // Prints message
            } // Ends try-catch

            System.out.println("Trying to peek front of empty queue"); // Announces front attempt
            try { // Wraps front in try-catch
                queue3.front(); // Expected: throws exception
            } catch (Exception e) { // Catches exception
                System.out.println("Exception: " + e.getMessage()); // Prints message
            } // Ends try-catch

            // Test Case 4: Single element
            System.out.println("\nTest Case 4: Single Element"); // Test case header
            CustomQueue queue4 = new CustomQueue(1); // Creates queue with size 1
            queue4.insert(999); // Inserts 999, end = 1
            System.out.println("Front: " + queue4.front()); // Expected: 999
            System.out.println("Remove: " + queue4.remove()); // Expected: 999
            System.out.println("Is empty? " + queue4.isEmpty()); // Expected: true
        } catch (Exception e) { // Catches unexpected exceptions
            System.out.println("Unexpected error: " + e.getMessage()); // Prints error
        } // Ends outer try-catch
    } // Summary: Tests queue with default size, custom size, edge cases, and single element, verifying insert, remove, front, isEmpty, and isFull operations.
}