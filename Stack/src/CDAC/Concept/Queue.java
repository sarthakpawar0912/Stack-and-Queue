package CDAC.Concept;
import java.util.Scanner;

// Class to implement a linear queue
class LinearQueue {

    private int[] arr; // Array to store queue elements

    private int front; // Index of front element

    private int rear; // Index of rear element

    // Constructor to initialize queue
    public LinearQueue(int size) {

        arr = new int[size];

        front = -1;

        rear = -1;
    }

    // Check if queue is empty
    public boolean isEmpty() {

        return front == rear && front == -1;
    }

    // Check if queue is full
    public boolean isFull() {
        return rear == arr.length - 1;
    }

    // Add element to queue
    public void push(int val) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        if (isEmpty()) {
            front = 0;
        }
        rear++;
        arr[rear] = val;
        System.out.println("Enqueued " + val);
    }

    // Remove element from queue
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int val = arr[front + 1];
        front++;
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        System.out.println("Dequeued " + val);
    }

    // View front element
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front + 1];
    }

    // Display queue contents
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front + 1; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

// Main class to test LinearQueue
public class Queue {
    public static void main(String[] args) {
        LinearQueue q = new LinearQueue(5);
        Scanner sc = new Scanner(System.in);
        int choice;

        // Menu-driven program
        do {
            System.out.println("\n0. Exit\n1. Push\n2. Pop\n3. Peek\n4. Display");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    q.push(val);
                    q.display();
                    break;
                case 2:
                    q.pop();
                    q.display();
                    break;
                case 3:
                    System.out.println("Front value: " + q.peek());
                    q.display();
                    break;
                case 4:
                    q.display();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}