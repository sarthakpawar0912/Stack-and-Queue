public class CustomeStack { // Declares a public class named CustomeStack (note: typo in "Custome", ideally "CustomStack")

    protected int[] data; // Array to store stack elements, protected for access within package and subclasses

    private static final int DEFAULT_SIZE = 10; // Constant for default stack size, private to this class, static for class-level sharing, final to prevent modification

    int ptr = -1; // Pointer to track the top of the stack, initialized to -1 (empty stack)

    // Constructor for default stack size
    public CustomeStack() { // Defines the no-arg constructor
        this(DEFAULT_SIZE); // Delegates to the parameterized constructor with DEFAULT_SIZE (10)
    }
    // Summary: This constructor ensures a stack is created with the default size of 10 by calling the parameterized constructor, avoiding duplicate initialization logic.


    // Constructor for custom stack size
    public CustomeStack(int size) { // Defines constructor that accepts a size parameter
        this.data = new int[size]; // Initializes the data array with the specified size, all elements default to 0
    }
    // Summary: This constructor creates a stack with a user-defined size by allocating an array of that size, allowing flexibility in stack capacity.


    // Pushes an item onto the stack
    public boolean push(int item) { // Method to add an item to the top of the stack, returns boolean to indicate success
        if (isFull()) { // Checks if the stack is full by calling isFull()
            System.out.println("Stack is Full"); // Prints error message if stack is full
            return false; // Returns false to indicate push failure
        } // If stack is full, execution stops here

        ptr++; // Increments pointer to point to the next empty slot
        data[ptr] = item; // Stores the item at the current top (ptr index)
        return true; // Returns true to indicate successful push

    }
    // Summary: This method adds an item to the top of the stack if there’s space, updating the pointer and array. It returns false and prints a message if the stack is full, ensuring safe operation.


    // Checks if the stack is full
    private boolean isFull() { // Private method to check if stack has reached capacity
        return ptr == data.length - 1; // Returns true if pointer is at the last array index, false otherwise
    }
    // Summary: This method efficiently checks if the stack is full by comparing the pointer to the last valid array index, used internally to prevent overflow in push.


    // Pops an item from the stack
    public int pop() throws Exception { // Method to remove and return the top item, may throw an exception
        if (isEmpty()) { // Checks if the stack is empty by calling isEmpty()
            throw new Exception("Cannot POP From an Empty stack..!!"); // Throws exception with message if stack is empty
        } // If stack is empty, execution stops here
        return data[ptr--]; // Returns the top item and decrements pointer in one step
    }
    // Summary: This method removes and returns the top item, reducing the pointer to reflect the new top. It throws an exception for empty stacks to prevent invalid access, ensuring robustness.


    // Peeks at the top item without removing it
    public int peek() throws Exception { // Method to view the top item, may throw an exception
        if (isEmpty()) { // Checks if the stack is empty
            throw new Exception("Cannot Peek From an Empty stack..!!"); // Throws exception if stack is empty
        } // If stack is empty, execution stops here
        return data[ptr]; // Returns the top item without modifying the stack
    }
    // Summary: This method allows inspection of the top item without altering the stack, throwing an exception for empty stacks to maintain safety.


    // Checks if the stack is empty
    private boolean isEmpty() { // Private method to check if stack has no elements
        return ptr == -1; // Returns true if pointer is -1 (initial empty state), false otherwise
    }
    // Summary: This method checks if the stack is empty by verifying if the pointer is at its initial value, used by pop and peek to prevent underflow.


    // Main function to test the CustomeStack implementation
    public static void main(String[] args) { // Entry point for testing the stack

       try {
           // Wraps tests in try-catch to handle exceptions
            // Test Case 1: Using default size (10)
            System.out.println("Test Case 1: Default Stack (size = 10)"); // Prints test case header
            CustomeStack stack1 = new CustomeStack(); // Creates a stack with default size (10)
            System.out.println("Is empty? " + stack1.isEmpty()); // Checks and prints if stack is empty (expected: true)


           // Push elements
            System.out.println("Pushing 1, 2, 3, 4, 5"); // Announces push operations
            stack1.push(1); // Pushes 1, ptr = 0, data[0] = 1
            stack1.push(2); // Pushes 2, ptr = 1, data[1] = 2
            stack1.push(3); // Pushes 3, ptr = 2, data[2] = 3
            stack1.push(4); // Pushes 4, ptr = 3, data[3] = 4
            stack1.push(5); // Pushes 5, ptr = 4, data[4] = 5
            System.out.println("Is empty? " + stack1.isEmpty()); // Checks if stack is empty (expected: false)
            System.out.println("Is full? " + stack1.isFull());   // Checks if stack is full (expected: false)


            // Peek
            System.out.println("Peek: " + stack1.peek()); // Views top item (expected: 5)


            // Pop elements
            System.out.println("Pop: " + stack1.pop()); // Pops top item (expected: 5), ptr = 3
            System.out.println("Pop: " + stack1.pop()); // Pops next item (expected: 4), ptr = 2
            System.out.println("Peek: " + stack1.peek()); // Views new top (expected: 3)


            // Push more elements to fill the stack
            System.out.println("Pushing 6, 7, 8, 9, 10, 11"); // Announces more pushes
            stack1.push(6);  // Pushes 6, ptr = 3
            stack1.push(7);  // Pushes 7, ptr = 4
            stack1.push(8);  // Pushes 8, ptr = 5
            stack1.push(9);  // Pushes 9, ptr = 6
            stack1.push(10); // Pushes 10, ptr = 7
            stack1.push(11); // Pushes 11, ptr = 8
            stack1.push(12); // Pushes 12, ptr = 9
            System.out.println("Is full? " + stack1.isFull()); // Checks if stack is full (expected: true)
            stack1.push(13); // Attempts to push 13 (expected: prints "Stack is Full", returns false)


            // Test Case 2: Custom size (3)
            System.out.println("\nTest Case 2: Custom Stack (size = 3)"); // Prints test case header
            CustomeStack stack2 = new CustomeStack(3); // Creates a stack with size 3
            System.out.println("Is empty? " + stack2.isEmpty()); // Checks if empty (expected: true)


            // Push elements
            System.out.println("Pushing 100, 200, 300, 400"); // Announces push operations
            stack2.push(100); // Pushes 100, ptr = 0
            stack2.push(200); // Pushes 200, ptr = 1
            stack2.push(300); // Pushes 300, ptr = 2
            stack2.push(400); // Attempts to push 400 (expected: prints "Stack is Full", returns false)
            System.out.println("Is full? " + stack2.isFull()); // Checks if full (expected: true)


            // Peek and pop
            System.out.println("Peek: " + stack2.peek()); // Views top item (expected: 300)
            System.out.println("Pop: " + stack2.pop());  // Pops top item (expected: 300), ptr = 1
            System.out.println("Pop: " + stack2.pop());  // Pops next item (expected: 200), ptr = 0
            System.out.println("Pop: " + stack2.pop());  // Pops last item (expected: 100), ptr = -1
            System.out.println("Is empty? " + stack2.isEmpty()); // Checks if empty (expected: true)


            // Test Case 3: Edge cases (empty stack operations)
            System.out.println("\nTest Case 3: Edge Cases"); // Prints test case header
            CustomeStack stack3 = new CustomeStack(2); // Creates a stack with size 2
            System.out.println("Trying to pop from empty stack"); // Announces pop attempt
            try { // Wraps pop in try-catch to handle exception
                stack3.pop(); // Attempts to pop (expected: throws exception)
            } catch (Exception e) { // Catches the thrown exception
                System.out.println("Exception: " + e.getMessage()); // Prints exception message
            } // Ends try-catch block


            System.out.println("Trying to peek from empty stack"); // Announces peek attempt
            try { // Wraps peek in try-catch
                stack3.peek(); // Attempts to peek (expected: throws exception)
            } catch (Exception e) { // Catches the exception
                System.out.println("Exception: " + e.getMessage()); // Prints exception message
            } // Ends try-catch block


            // Test Case 4: Single element
            System.out.println("\nTest Case 4: Single Element"); // Prints test case header
            CustomeStack stack4 = new CustomeStack(1); // Creates a stack with size 1
            stack4.push(999); // Pushes 999, ptr = 0
            System.out.println("Peek: " + stack4.peek()); // Views top item (expected: 999)
            System.out.println("Pop: " + stack4.pop());   // Pops item (expected: 999), ptr = -1
            System.out.println("Is empty? " + stack4.isEmpty()); // Checks if empty (expected: true)
        } catch (Exception e) { // Catches any unexpected exceptions
            System.out.println("Unexpected error: " + e.getMessage()); // Prints error message

       } // Ends outer try-catch block

    }
    // Summary: The main method tests the stack with four cases: default size operations, custom size, edge cases (empty stack), and single-element stack. It exercises push, pop, peek, isEmpty, and isFull, verifying correct behavior and error handling through printed outputs.

 }