import java.util.Stack; // Imports Stack class for parentheses matching

public class ValidParentheses { // Declares public class for validating parentheses

    // Determines if a string of parentheses is valid
    public boolean isValid(String s) { // Method to check parentheses validity
        Stack<Character> stack = new Stack<>(); // Initializes stack to store open brackets

        for (char ch : s.toCharArray()) { // Iterates through each character in string
            if (ch == '(' || ch == '{' || ch == '[') { // Checks if character is an open bracket
                stack.push(ch); // Pushes open bracket onto stack
            } else { // Character is a close bracket
                if (stack.isEmpty()) { // Checks if stack is empty (no open bracket to match)
                    return false; // Returns false as close bracket is unmatched
                } // Handles empty stack case

                char top = stack.pop(); // Pops top open bracket from stack
                if (ch == ')' && top != '(') { // Checks if close parenthesis matches open
                    return false; // Returns false for mismatch
                } // Mismatch for parentheses
                if (ch == '}' && top != '{') { // Checks for curly brace match
                    return false; // Returns false for mismatch
                } // Mismatch for curly braces
                if (ch == ']' && top != '[') { // Checks for square bracket match
                    return false; // Returns false for mismatch
                } // Mismatch for square brackets
            } // End of close bracket handling
        } // End of string iteration

        return stack.isEmpty(); // Returns true if all brackets matched, false if unclosed brackets remain
    } // Summary: Uses stack to match parentheses, ensuring open brackets are closed correctly (O(n) time, O(n) space).


    // Helper method to display test results
    private static void displayTestResult(String s, boolean result) { // Prints test case result
        System.out.println("Input: s = \"" + s + "\""); // Prints input string
        System.out.println("Output: " + result); // Prints validity result
        System.out.println(); // Adds newline for readability
    } // Summary: Formats test case output for clarity.


    // Main function to test isValid method
    public static void main(String[] args) { // Entry point for testing

        ValidParentheses solution = new ValidParentheses(); // Creates instance of ValidParentheses


        // Test Case 1: Example 1 from problem
        System.out.println("Test Case 1: Example 1"); // Test case header
        String s1 = "()"; // Input: "()"
        boolean result1 = solution.isValid(s1); // Checks validity
        displayTestResult(s1, result1); // Expected: true


        // Test Case 2: Example 2 from problem
        System.out.println("Test Case 2: Example 2"); // Test case header
        String s2 = "()[]{}"; // Input: "()[]{}"
        boolean result2 = solution.isValid(s2); // Checks validity
        displayTestResult(s2, result2); // Expected: true


        // Test Case 3: Example 3 from problem
        System.out.println("Test Case 3: Example 3"); // Test case header
        String s3 = "(]"; // Input: "(]"
        boolean result3 = solution.isValid(s3); // Checks validity
        displayTestResult(s3, result3); // Expected: false


        // Test Case 4: Example 4 from problem
        System.out.println("Test Case 4: Example 4"); // Test case header
        String s4 = "([])"; // Input: "([])"
        boolean result4 = solution.isValid(s4); // Checks validity
        displayTestResult(s4, result4); // Expected: true


        // Test Case 5: Single open bracket
        System.out.println("Test Case 5: Single Open Bracket"); // Test case header
        String s5 = "("; // Input: "("
        boolean result5 = solution.isValid(s5); // Checks validity
        displayTestResult(s5, result5); // Expected: false


        // Test Case 6: Single close bracket
        System.out.println("Test Case 6: Single Close Bracket"); // Test case header
        String s6 = ")"; // Input: ")"
        boolean result6 = solution.isValid(s6); // Checks validity
        displayTestResult(s6, result6); // Expected: false

        // Test Case 7: Complex nested brackets
        System.out.println("Test Case 7: Complex Nested Brackets"); // Test case header
        String s7 = "{[()()]}{}"; // Input: "{[()()]}{}"
        boolean result7 = solution.isValid(s7); // Checks validity
        displayTestResult(s7, result7); // Expected: true

        // Test Case 8: Mismatched nested brackets
        System.out.println("Test Case 8: Mismatched Nested Brackets"); // Test case header
        String s8 = "{[(])"; // Input: "{[(])"
        boolean result8 = solution.isValid(s8); // Checks validity
        displayTestResult(s8, result8); // Expected: false

        // Test Case 9: Empty string
        System.out.println("Test Case 9: Empty String"); // Test case header
        String s9 = ""; // Input: ""
        boolean result9 = solution.isValid(s9); // Checks validity
        displayTestResult(s9, result9); // Expected: true (valid per stack logic)
    } // Summary: Tests isValid with all examples, single brackets, complex nesting, mismatched cases, and empty string.
}