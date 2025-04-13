import java.util.Stack; // Imports Stack class for implementation

public class ImplementationOfQueueusingStack { // Declares public class to implement queue using two stacks

    private Stack<Integer> s1; // Input stack for push operations

    private Stack<Integer> s2; // Output stack for pop and peek operations


    // Constructor to initialize the queue
    public ImplementationOfQueueusingStack() { // Initializes a new MyQueue instance
        s1 = new Stack<>(); // Creates empty stack s1 for input
        s2 = new Stack<>(); // Creates empty stack s2 for output
    } // Summary: Initializes two empty stacks to store queue elements, preparing for FIFO operations.


    // Pushes element x to the back of the queue
    public void push(int x) { // Method to add element to queue’s rear
        s1.push(x); // Pushes x onto s1 (input stack)
    } // Summary: Adds element to s1, which acts as the rear of the queue, maintaining elements in push order (O(1)).


    // Removes the element from the front of the queue and returns it
    public int pop() { // Method to remove and return front element
        if (s2.isEmpty()) { // Checks if output stack is empty
            while (!s1.isEmpty()) { // Transfers all elements from s1 to s2
                s2.push(s1.pop()); // Pops from s1 and pushes to s2, reversing order
            } // After transfer, s2’s top is queue’s front
        } // If s2 wasn’t empty, skip transfer
        return s2.pop(); // Pops and returns top of s2 (front of queue)
    } // Summary: Ensures s2 has the front element by transferring from s1 if needed, then pops from s2 (amortized O(1)).


    // Returns the element at the front of the queue
    public int peek() { // Method to view front element without removal
        if (s2.isEmpty()) { // Checks if output stack is empty
            while (!s1.isEmpty()) { // Transfers all elements from s1 to s2
                s2.push(s1.pop()); // Pops from s1 and pushes to s2, reversing order
            } // After transfer, s2’s top is queue’s front
        } // If s2 wasn’t empty, skip transfer
        return s2.peek(); // Returns top of s2 (front of queue) without popping
    } // Summary: Ensures s2 has the front element, then peeks at s2’s top (amortized O(1)).


    // Returns true if the queue is empty, false otherwise
    public boolean empty() { // Method to check if queue is empty
        return s1.isEmpty() && s2.isEmpty(); // True if both stacks are empty
    } // Summary: Queue is empty only if no elements exist in s1 or s2 (O(1)).


    // Helper method to display queue contents (for testing)
    private void display() { // Prints queue in FIFO order
        if (empty()) { // Checks if queue is empty
            System.out.println("Queue: Empty"); // Prints empty state
            return; // Exits method
        } // Handles empty case
        Stack<Integer> temp = new Stack<>(); // Temporary stack for display
        // Copy s2 to temp in reverse order
        while (!s2.isEmpty()) { // Empties s2 into temp
            temp.push(s2.pop()); // Transfers elements
        } // s2 is now empty
        // Transfer s1 to s2 to prepare front
        while (!s1.isEmpty()) { // Moves s1 to s2
            s2.push(s1.pop()); // Reverses order
        } // s1 is now empty

        // Print from s2 (front to rear)
        System.out.print("Queue: "); // Labels output
        for (int i = s2.size() - 1; i >= 0; i--) { // Iterates from front to rear
            System.out.print(s2.get(i)); // Prints element
            if (i > 0) { // Checks if not the last element
                System.out.print(" -> "); // Adds arrow separator
            } // Adds arrow unless it’s the last item
        } // Ends printing loop
        System.out.println(); // Newline for clean output
        // Restore s2 to temp
        while (!temp.isEmpty()) { // Moves temp back to s2
            s2.push(temp.pop()); // Restores s2
        } // s2 is restored
    } // Summary: Displays queue in FIFO order (front to rear) with arrows, preserving queue state by using a temporary stack.


    // Main function to test MyQueue implementation
    public static void main(String[] args) { // Entry point for testing
        try { // Wraps tests in try-catch for robustness
            // Test Case 1: Example from problem (matches Input/Output)
            System.out.println("Test Case 1: Example from Problem"); // Test case header
            ImplementationOfQueueusingStack queue1 = new ImplementationOfQueueusingStack(); // Creates new queue
            System.out.println("Initializing queue"); // Announces action
            queue1.display(); // Expected: Queue: Empty
            System.out.println("Pushing 1"); // Announces push
            queue1.push(1); // Queue: [1]
            queue1.display(); // Expected: Queue: 1
            System.out.println("Pushing 2"); // Announces push
            queue1.push(2); // Queue: [1, 2]
            queue1.display(); // Expected: Queue: 1 -> 2
            System.out.println("Peek: " + queue1.peek()); // Expected: 1
            System.out.println("Pop: " + queue1.pop()); // Expected: 1
            queue1.display(); // Expected: Queue: 2
            System.out.println("Empty? " + queue1.empty()); // Expected: false
            queue1.display(); // Expected: Queue: 2

            // Test Case 2: Multiple pushes and pops
            System.out.println("\nTest Case 2: Multiple Pushes and Pops"); // Test case header
            ImplementationOfQueueusingStack queue2 = new ImplementationOfQueueusingStack(); // Creates new queue
            queue2.display(); // Expected: Queue: Empty
            System.out.println("Pushing 3, 4, 5, 6"); // Announces pushes
            queue2.push(3); // Queue: [3]
            queue2.push(4); // Queue: [3, 4]
            queue2.push(5); // Queue: [3, 4, 5]
            queue2.push(6); // Queue: [3, 4, 5, 6]
            queue2.display(); // Expected: Queue: 3 -> 4 -> 5 -> 6
            System.out.println("Pop: " + queue2.pop()); // Expected: 3
            queue2.display(); // Expected: Queue: 4 -> 5 -> 6
            System.out.println("Peek: " + queue2.peek()); // Expected: 4
            System.out.println("Pop: " + queue2.pop()); // Expected: 4
            queue2.display(); // Expected: Queue: 5 -> 6
            System.out.println("Pushing 7"); // Announces push
            queue2.push(7); // Queue: [5, 6, 7]
            queue2.display(); // Expected: Queue: 5 -> 6 -> 7
            System.out.println("Empty? " + queue2.empty()); // Expected: false

            // Test Case 3: Edge case - Empty queue
            System.out.println("\nTest Case 3: Empty Queue"); // Test case header
            ImplementationOfQueueusingStack queue3 = new ImplementationOfQueueusingStack(); // Creates new queue
            queue3.display(); // Expected: Queue: Empty
            System.out.println("Empty? " + queue3.empty()); // Expected: true
            System.out.println("Pushing 8"); // Announces push
            queue3.push(8); // Queue: [8]
            queue3.display(); // Expected: Queue: 8
            System.out.println("Pop: " + queue3.pop()); // Expected: 8
            queue3.display(); // Expected: Queue: Empty
            System.out.println("Empty? " + queue3.empty()); // Expected: true

            // Test Case 4: Single element
            System.out.println("\nTest Case 4: Single Element"); // Test case header
            ImplementationOfQueueusingStack queue4 = new ImplementationOfQueueusingStack(); // Creates new queue
            queue4.display(); // Expected: Queue: Empty
            System.out.println("Pushing 9"); // Announces push
            queue4.push(9); // Queue: [9]
            queue4.display(); // Expected: Queue: 9
            System.out.println("Peek: " + queue4.peek()); // Expected: 9
            System.out.println("Pop: " + queue4.pop()); // Expected: 9
            queue4.display(); // Expected: Queue: Empty
            System.out.println("Empty? " + queue4.empty()); // Expected: true
        } catch (Exception e) { // Catches unexpected errors
            System.out.println("Unexpected error: " + e.getMessage()); // Prints error
        } // Ends try-catch
    } // Summary: Tests MyQueue with example case, multiple operations, empty queue, and single element, using display to visualize queue state.
}