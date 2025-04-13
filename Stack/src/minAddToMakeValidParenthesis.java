import java.util.Stack; // Imports Stack class for tracking open parentheses

public class minAddToMakeValidParenthesis { // Declares public class for parentheses solution

    // Returns minimum number of parentheses to add to make s valid
    public int minAddToMakeValid(String s) { // Method to compute minimum additions
        Stack<Character> stack = new Stack<>(); // Stack to store unmatched open parentheses
        int unmatchedClose = 0; // Counter for unmatched closing parentheses

        for (char ch : s.toCharArray()) { // Iterates through each character in string
            if (ch == '(') { // Checks if character is an open parenthesis
                stack.push(ch); // Pushes open parenthesis to stack
            } else { // Character is a closing parenthesis
                if (!stack.isEmpty()) { // Checks if there’s an open parenthesis to match
                    stack.pop(); // Pops matching open parenthesis (forms valid pair)
                } else { // No open parenthesis available
                    unmatchedClose++; // Increments counter for unmatched close parenthesis
                } // Tracks need for additional open parenthesis
            } // End of character processing
        } // End of string iteration

        int unmatchedOpen = stack.size(); // Number of unmatched open parentheses
        return unmatchedOpen + unmatchedClose; // Total additions needed
    } // Summary: Uses stack to track unmatched open parentheses, counts unmatched close parentheses, returns total additions (O(n) time, O(n) space).


    // Helper method to display test results
    private static void displayTestResult(String s, int result) { // Prints test case result
        System.out.println("Input: s = \"" + s + "\""); // Prints input string
        System.out.println("Output: " + result); // Prints number of additions
        System.out.println(); // Adds newline for readability
    } // Summary: Formats test case output for clarity.


    // Main function to test minAddToMakeValid
    public static void main(String[] args) { // Entry point for testing

        minAddToMakeValidParenthesis solution = new minAddToMakeValidParenthesis(); // Creates instance of Solution

        // Test Case 1: Example 1 from problem
        System.out.println("Test Case 1: Example 1"); // Test case header
        String s1 = "())"; // Input: "())"
        int result1 = solution.minAddToMakeValid(s1); // Computes additions
        displayTestResult(s1, result1); // Expected: 1

        // Test Case 2: Example 2 from problem
        System.out.println("Test Case 2: Example 2"); // Test case header
        String s2 = "((("; // Input: "((("
        int result2 = solution.minAddToMakeValid(s2); // Computes additions
        displayTestResult(s2, result2); // Expected: 3


        // Test Case 3: Valid string
        System.out.println("Test Case 3: Valid String"); // Test case header
        String s3 = "()()"; // Input: "()()"
        int result3 = solution.minAddToMakeValid(s3); // Computes additions
        displayTestResult(s3, result3); // Expected: 0


        // Test Case 4: All closing
        System.out.println("Test Case 4: All Closing"); // Test case header
        String s4 = ")))"; // Input: ")))"
        int result4 = solution.minAddToMakeValid(s4); // Computes additions
        displayTestResult(s4, result4); // Expected: 3


        // Test Case 5: Mixed unbalanced
        System.out.println("Test Case 5: Mixed Unbalanced"); // Test case header
        String s5 = "())("; // Input: "())("
        int result5 = solution.minAddToMakeValid(s5); // Computes additions
        displayTestResult(s5, result5); // Expected: 2


        // Test Case 6: Empty string
        System.out.println("Test Case 6: Empty String"); // Test case header
        String s6 = ""; // Input: ""
        int result6 = solution.minAddToMakeValid(s6); // Computes additions
        displayTestResult(s6, result6); // Expected: 0


        // Test Case 7: Complex string
        System.out.println("Test Case 7: Complex String"); // Test case header
        String s7 = "((())()"; // Input: "((())()"
        int result7 = solution.minAddToMakeValid(s7); // Computes additions
        displayTestResult(s7, result7); // Expected: 1
    } // Summary: Tests minAddToMakeValid with examples, valid string, all closing, mixed, empty, and complex cases.
}