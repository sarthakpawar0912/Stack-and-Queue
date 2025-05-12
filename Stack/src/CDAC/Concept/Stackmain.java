package CDAC.Concept;
import java.util.Scanner;

// Class to implement a stack data structure
class Stack {

    private int[] arr; // Array to store stack elements

    private int top; // Index of the top element

    private int capacity; // Maximum capacity of the stack

    // Constructor to initialize the stack
    public Stack(int size) {

        arr = new int[size];

        capacity = size;

        top = -1; // Stack is initially empty

    }

    // Method to push an element onto the stack
    public void push(int val) {

        if (isFull()) {

            throw new RuntimeException("Stack is full");

        }

        top++;
        arr[top] = val;
        System.out.println("Pushed " + val + " onto the stack");
    }

    // Method to pop an element from the stack
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int val = arr[top]; // Store the value to be popped
        top--;
        System.out.println("Popped " + val + " from the stack");
    }

    // Method to peek at the top element of the stack
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Method to display the current contents of the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack contents (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

// Main class to test the Stack implementation
public class Stackmain {
    public static void main(String[] args) {
        Stack s = new Stack(5); // Create a stack of size 5
        Scanner sc = new Scanner(System.in);
        int choice;

        // Display menu and handle user input
        do {
            System.out.println("\n=== Stack Operations Menu ===");
            System.out.println("0. Exit");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting program...");
                    break;
                case 1:
                    System.out.print("Enter the value to be pushed: ");
                    int val = sc.nextInt();
                    s.push(val);
                    s.display(); // Display stack after push
                    break;
                case 2:
                    s.pop();
                    s.display(); // Display stack after pop
                    break;
                case 3:
                    System.out.println("The value at the top of the stack is: " + s.peek());
                    s.display(); // Display stack after peek
                    break;
                case 4:
                    s.display(); // Display current stack contents
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        sc.close(); // Close the scanner
    }
}