public class CircularQueue { // Declares public class for circular queue implementation

    protected int[] data; // Array to store queue elements, protected for potential subclassing

    private static final int DEFAULT_SIZE = 10; // Constant for default queue size, private, static, final

    protected int end = 0; // Tracks rear index where next item is inserted, initialized to 0

    protected int front = 0; // Tracks front index of first item, initialized to 0

    private int size = 0; // Tracks number of elements in queue, initialized to 0 (empty)

    // Constructor for default queue size
    public CircularQueue() { // No-arg constructor for default size
        this(DEFAULT_SIZE); // Delegates to parameterized constructor with DEFAULT_SIZE (10)
    } // Summary: Creates a circular queue with default size 10, reusing parameterized constructor.

    // Constructor for custom queue size
    public CircularQueue(int size) { // Constructor with custom size parameter
        this.data = new int[size]; // Initializes data array with specified size, elements default to 0
    } // Summary: Creates a circular queue with user-defined size, allocating array memory.

    // Checks if the queue is full
    private boolean isFull() { // Private method to check if queue has reached capacity
        return size == data.length; // Returns true if size equals array length, false otherwise
    } // Summary: Determines if queue is full by checking if size matches array capacity, preventing overflow.

    // Checks if the queue is empty
    private boolean isEmpty() { // Private method to check if queue has no elements
        return size == 0; // Returns true if size is 0 (no elements), false otherwise
    } // Summary: Checks if queue is empty by verifying if size is 0, preventing underflow.

    // Inserts an item at the rear of the queue
    public boolean insert(int item) { // Method to add item to rear, returns boolean for success
        if (isFull()) { // Checks if queue is full
            System.out.println("Queue is Full"); // Prints error message if no space
            return false; // Returns false to indicate insertion failure
        } // If full, stops execution here

        data[end++] = item; // Stores item at rear index, increments end
        end = end % data.length; // Wraps end around to 0 if it reaches array length (circular)
        size++; // Increments size to track number of elements
        return true; // Returns true to confirm successful insertion
    } // Summary: Adds item to rear, updates end with modulo for circularity, and increments size. Returns false if full.

    // Removes and returns the front item
    public int remove() throws Exception { // Method to remove front item, may throw exception
        if (isEmpty()) { // Checks if queue is empty
            throw new Exception("Cannot REMOVE From an Empty Queue..!!"); // Throws exception if empty
        } // If empty, stops execution here

        int removed = data[front]; // Stores front item for return
        front++; // Advances front to next item
        front = front % data.length; // Wraps front around to 0 if it reaches array length
        size--; // Decrements size to reflect removal
        return removed; // Returns removed item
    } // Summary: Removes and returns front item, advances front with modulo for circularity, decrements size. Throws exception if empty.

    // Returns the front item without removing it
    public int front() throws Exception { // Method to view front item, may throw exception
        if (isEmpty()) { // Checks if queue is empty
            throw new Exception("Empty QUEUE..!!"); // Throws exception if empty
        } // If empty, stops execution here
        return data[front]; // Returns front item without modification
    } // Summary: Returns front item without altering queue, throws exception if empty.

    // Displays queue elements in linked list-like format
    public void display() { // Method to print queue elements with arrows
        if (isEmpty()) { // Checks if queue is empty
            System.out.println("Empty"); // Prints "Empty" for no elements
            return; // Exits method
        } // Handles empty case

        for (int i = 0; i < size; i++) { // Loops through size elements
            int index = (front + i) % data.length; // Calculates index from front, wrapping around
            System.out.print(data[index]); // Prints current element
            if (i < size - 1) { // Checks if not the last element
                System.out.print(" -> "); // Prints arrow separator
            } // Adds arrow unless it’s the last item
        } // Ends loop through elements
        System.out.println(); // Prints newline for clean output
    } // Summary: Prints queue elements from front to rear in format "item1 -> item2 -> ...", or "Empty" if no elements, using modulo for circular traversal.

    // Main function to test CircularQueue implementation
    public static void main(String[] args) { // Entry point for testing queue operations
        try { // Wraps tests in try-catch to handle exceptions
            // Test Case 1: Default queue (size = 10)
            System.out.println("Test Case 1: Default Queue (size = 10)"); // Prints test case header
            CircularQueue queue1 = new CircularQueue(); // Creates queue with default size
            System.out.print("Queue: "); // Labels initial queue state
            queue1.display(); // Displays queue (expected: Empty)

            // Insert elements
            System.out.println("Inserting 10, 20, 30, 40, 50"); // Announces insertions
            queue1.insert(10); // end = 1, size = 1, data[0] = 10
            queue1.insert(20); // end = 2, size = 2, data[1] = 20
            queue1.insert(30); // end = 3, size = 3, data[2] = 30
            queue1.insert(40); // end = 4, size = 4, data[3] = 40
            queue1.insert(50); // end = 5, size = 5, data[4] = 50
            System.out.print("Queue: "); // Labels queue state
            queue1.display(); // Expected: 10 -> 20 -> 30 -> 40 -> 50
            System.out.println("Is empty? " + queue1.isEmpty()); // Expected: false
            System.out.println("Is full? " + queue1.isFull()); // Expected: false
            System.out.println("Front: " + queue1.front()); // Expected: 10

            // Remove elements
            System.out.println("Removing two elements"); // Announces removals
            System.out.println("Remove: " + queue1.remove()); // Expected: 10, front = 1
            System.out.println("Remove: " + queue1.remove()); // Expected: 20, front = 2
            System.out.print("Queue: "); // Labels queue state
            queue1.display(); // Expected: 30 -> 40 -> 50
            System.out.println("Front: " + queue1.front()); // Expected: 30

            // Insert to wrap around
            System.out.println("Inserting 60, 70, 80, 90, 100, 110"); // Announces insertions
            queue1.insert(60); // end = 6, size = 4
            queue1.insert(70); // end = 7, size = 5
            queue1.insert(80); // end = 8, size = 6
            queue1.insert(90); // end = 9, size = 7
            queue1.insert(100); // end = 0, size = 8
            queue1.insert(110); // end = 1, size = 9
            System.out.print("Queue: "); // Labels queue state
            queue1.display(); // Expected: 30 -> 40 -> 50 -> 60 -> 70 -> 80 -> 90 -> 100 -> 110
            System.out.println("Is full? " + queue1.isFull()); // Expected: false
            System.out.println("Inserting 120 (should fail)"); // Announces insertion
            queue1.insert(120); // Expected: Queue is Full, false
            System.out.print("Queue: "); // Labels queue state
            queue1.display(); // Expected: unchanged

            // Remove and insert to test circularity
            System.out.println("Removing one element"); // Announces removal
            System.out.println("Remove: " + queue1.remove()); // Expected: 30, front = 3
            System.out.println("Inserting 120"); // Announces insertion
            queue1.insert(120); // end = 2, size = 9
            System.out.print("Queue: "); // Labels queue state
            queue1.display(); // Expected: 40 -> 50 -> 60 -> 70 -> 80 -> 90 -> 100 -> 110 -> 120

            // Test Case 2: Custom size (3)
            System.out.println("\nTest Case 2: Custom Queue (size = 3)"); // Test case header
            CircularQueue queue2 = new CircularQueue(3); // Creates queue with size 3
            System.out.print("Queue: "); // Labels initial state
            queue2.display(); // Expected: Empty
            System.out.println("Is empty? " + queue2.isEmpty()); // Expected: true

            // Insert elements
            System.out.println("Inserting 100, 200, 300, 400"); // Announces insertions
            queue2.insert(100); // end = 1, size = 1
            queue2.insert(200); // end = 2, size = 2
            queue2.insert(300); // end = 0, size = 3
            System.out.print("Queue: "); // Labels queue state
            queue2.display(); // Expected: 100 -> 200 -> 300
            queue2.insert(400); // Expected: Queue is Full, false
            System.out.println("Is full? " + queue2.isFull()); // Expected: true

            // Remove and insert
            System.out.println("Removing one element"); // Announces removal
            System.out.println("Remove: " + queue2.remove()); // Expected: 100, front = 1
            System.out.println("Inserting 400"); // Announces insertion
            queue2.insert(400); // end = 1, size = 3
            System.out.print("Queue: "); // Labels queue state
            queue2.display(); // Expected: 200 -> 300 -> 400
            System.out.println("Removing all elements"); // Announces removals
            System.out.println("Remove: " + queue2.remove()); // Expected: 200
            System.out.println("Remove: " + queue2.remove()); // Expected: 300
            System.out.println("Remove: " + queue2.remove()); // Expected: 400
            System.out.print("Queue: "); // Labels queue state
            queue2.display(); // Expected: Empty
            System.out.println("Is empty? " + queue2.isEmpty()); // Expected: true

            // Test Case 3: Edge cases (empty queue)
            System.out.println("\nTest Case 3: Edge Cases"); // Test case header
            CircularQueue queue3 = new CircularQueue(2); // Creates queue with size 2
            System.out.print("Queue: "); // Labels initial state
            queue3.display(); // Expected: Empty
            System.out.println("Trying to remove from empty queue"); // Announces attempt
            try { // Wraps remove
                queue3.remove(); // Expected: throws exception
            } catch (Exception e) { // Catches exception
                System.out.println("Exception: " + e.getMessage()); // Prints message
            } // Ends try-catch

            System.out.println("Trying to peek front of empty queue"); // Announces attempt
            try { // Wraps front
                queue3.front(); // Expected: throws exception
            } catch (Exception e) { // Catches exception
                System.out.println("Exception: " + e.getMessage()); // Prints message
            } // Ends try-catch

            // Test Case 4: Single element
            System.out.println("\nTest Case 4: Single Element"); // Test case header
            CircularQueue queue4 = new CircularQueue(1); // Creates queue with size 1
            System.out.println("Inserting 999"); // Announces insertion
            queue4.insert(999); // end = 0, size = 1
            System.out.print("Queue: "); // Labels queue state
            queue4.display(); // Expected: 999
            System.out.println("Front: " + queue4.front()); // Expected: 999
            System.out.println("Remove: " + queue4.remove()); // Expected: 999
            System.out.print("Queue: "); // Labels queue state
            queue4.display(); // Expected: Empty
            System.out.println("Is empty? " + queue4.isEmpty()); // Expected: true
        } catch (Exception e) { // Catches unexpected exceptions
            System.out.println("Unexpected error: " + e.getMessage()); // Prints error
        } // Ends outer try-catch
    } // Summary: Tests circular queue with default size, custom size, edge cases, and single element, using display to show queue state in linked list-like format.
}