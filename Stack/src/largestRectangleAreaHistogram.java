import java.util.Stack; // Imports Stack class for monotonic stack implementation

public class largestRectangleAreaHistogram { // Declares public class for histogram solution

    // Finds the largest rectangle area in the histogram
    public int largestRectangleArea(int[] heights) { // Method to compute max rectangle area
        if (heights == null || heights.length == 0) { // Checks for null or empty input
            return 0; // Returns 0 for invalid input
        } // Handles edge case

        Stack<Integer> stack = new Stack<>(); // Stack to store indices of bars in increasing height order
        int maxArea = 0; // Tracks the maximum rectangle area found

        for (int i = 0; i <= heights.length; i++) { // Loops through array, including one extra iteration
            int currentHeight = (i == heights.length) ? 0 : heights[i]; // Uses 0 for end to process remaining bars
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) { // While stack has bars taller than current
                int height = heights[stack.pop()]; // Pops index and gets height of bar
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Width: i (current) to left boundary
                int area = height * width; // Calculates area for popped bar
                maxArea = Math.max(maxArea, area); // Updates max area if larger
            } // Processes all bars that can’t extend right
            stack.push(i); // Pushes current index onto stack
        } // End of array processing

        return maxArea; // Returns the largest area found
    } // Summary: Uses a monotonic stack to compute max rectangle area by tracking bar boundaries, O(n) time.

    // Helper method to display histogram (for visualization in testing)
    private static void displayHistogram(int[] heights) { // Prints histogram as bars

        System.out.print("Histogram: ["); // Starts histogram display
        for (int i = 0; i < heights.length; i++) { // Loops through heights
            System.out.print(heights[i]); // Prints height
            if (i < heights.length - 1) { // Checks if not last element
                System.out.print(", "); // Adds separator
            } // Formats output
        } // Ends loop
        System.out.println("]"); // Closes histogram display
    } // Summary: Displays histogram array for clarity in test cases.


    // Main function to test largestRectangleArea
    public static void main(String[] args) { // Entry point for testing

        largestRectangleAreaHistogram solution = new largestRectangleAreaHistogram(); // Creates solution instance

        // Test Case 1: Example 1 from problem
        System.out.println("Test Case 1: Example 1"); // Test case header
        int[] heights1 = {2, 1, 5, 6, 2, 3}; // Input: [2,1,5,6,2,3]
        displayHistogram(heights1); // Displays histogram
        int result1 = solution.largestRectangleArea(heights1); // Computes max area
        System.out.println("Largest Rectangle Area: " + result1); // Expected: 10
        System.out.println(); // Newline for readability

        // Test Case 2: Example 2 from problem
        System.out.println("Test Case 2: Example 2"); // Test case header
        int[] heights2 = {2, 4}; // Input: [2,4]
        displayHistogram(heights2); // Displays histogram
        int result2 = solution.largestRectangleArea(heights2); // Computes max area
        System.out.println("Largest Rectangle Area: " + result2); // Expected: 4
        System.out.println(); // Newline for readability

        // Test Case 3: Single bar
        System.out.println("Test Case 3: Single Bar"); // Test case header
        int[] heights3 = {7}; // Input: [7]
        displayHistogram(heights3); // Displays histogram
        int result3 = solution.largestRectangleArea(heights3); // Computes max area
        System.out.println("Largest Rectangle Area: " + result3); // Expected: 7
        System.out.println(); // Newline for readability

        // Test Case 4: All equal heights
        System.out.println("Test Case 4: All Equal Heights"); // Test case header
        int[] heights4 = {3, 3, 3, 3}; // Input: [3,3,3,3]
        displayHistogram(heights4); // Displays histogram
        int result4 = solution.largestRectangleArea(heights4); // Computes max area
        System.out.println("Largest Rectangle Area: " + result4); // Expected: 12
        System.out.println(); // Newline for readability

        // Test Case 5: Zero heights
        System.out.println("Test Case 5: Zero Heights"); // Test case header
        int[] heights5 = {0, 0, 0}; // Input: [0,0,0]
        displayHistogram(heights5); // Displays histogram
        int result5 = solution.largestRectangleArea(heights5); // Computes max area
        System.out.println("Largest Rectangle Area: " + result5); // Expected: 0
        System.out.println(); // Newline for readability

        // Test Case 6: Large input with varied heights
        System.out.println("Test Case 6: Varied Heights"); // Test case header
        int[] heights6 = {1, 2, 3, 4, 5, 4, 3, 2, 1}; // Input: [1,2,3,4,5,4,3,2,1]
        displayHistogram(heights6); // Displays histogram
        int result6 = solution.largestRectangleArea(heights6); // Computes max area
        System.out.println("Largest Rectangle Area: " + result6); // Expected: 15
        System.out.println(); // Newline for readability
    } // Summary: Tests largestRectangleArea with example cases, single bar, equal heights, zero heights, and varied heights.
}