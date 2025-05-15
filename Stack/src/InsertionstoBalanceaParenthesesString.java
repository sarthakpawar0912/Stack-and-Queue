import java.util.Stack; // Imports Stack class for tracking open parentheses

public class InsertionstoBalanceaParenthesesString { // Declares public class for parentheses balancing solution

    // Returns minimum number of insertions to balance s
    public int minInsertions(String s) {

        Stack<Character> stack = new Stack<>();

        int insertions = 0; // Counter for required insertions

        int i = 0; // Index to iterate through string

        while (i < s.length()) { // Loops through string characters

            char ch = s.charAt(i); // Gets current character

            if (ch == '(') { // If open parenthesis

                stack.push(ch); // Pushes to stack, expecting )) later

                i++; // Moves to next character

            } else { // If closing parenthesis

                if (i + 1 < s.length() && s.charAt(i + 1) == ')') { // Checks for )) pair

                    if (!stack.isEmpty()) { // If there’s an open parenthesis
                        stack.pop(); // Pops matching ( to form ()))
                    } else { // No open parenthesis
                        insertions++; // Needs ( to match ))
                    } // Handles unmatched ))
                    i += 2; // Skips both ) in pair
                } else { // Single ) or last character
                    if (!stack.isEmpty()) { // If there’s an open parenthesis
                        stack.pop(); // Pops ( to partially match
                        insertions++; // Needs one ) to complete ))
                    } else { // No open parenthesis
                        insertions += 2; // Needs ( and ) to form ())
                    }
                    // Handles unmatched single )
                    i++; // Moves to next character
                } // End of single ) handling
            } // End of character processing
        } // End of string iteration


        insertions += stack.size() * 2; // Each leftover ( needs ))
        return insertions; // Returns total insertions needed

    } // Summary: Uses stack to track open (, processes ) in pairs, counts insertions for unmatched or incomplete pairs (O(n) time, O(n) space).


    // Helper method to display test results
    private static void displayTestResult(String s, int result) { // Prints test case result
        System.out.println("Input: s = \"" + s + "\""); // Prints input string
        System.out.println("Output: " + result); // Prints number of insertions
        System.out.println(); // Adds newline for readability
    } // Summary: Formats test case output for clarity.

    // Main function to test minInsertions
    public static void main(String[] args) { // Entry point for testing

        InsertionstoBalanceaParenthesesString solution = new InsertionstoBalanceaParenthesesString(); // Creates instance of Solution

        // Test Case 1: Example 1 from problem
        System.out.println("Test Case 1: Example 1"); // Test case header
        String s1 = "(()))"; // Input: "(()))"
        int result1 = solution.minInsertions(s1); // Computes insertions
        displayTestResult(s1, result1); // Expected: 1

        // Test Case 2: Example 2 from problem
        System.out.println("Test Case 2: Example 2"); // Test case header
        String s2 = "())"; // Input: "())"
        int result2 = solution.minInsertions(s2); // Computes insertions
        displayTestResult(s2, result2); // Expected: 0

        // Test Case 3: Example 3 from problem
        System.out.println("Test Case 3: Example 3"); // Test case header
        String s3 = "))())("; // Input: "))())("
        int result3 = solution.minInsertions(s3); // Computes insertions
        displayTestResult(s3, result3); // Expected: 3

        // Test Case 4: Valid complex string
        System.out.println("Test Case 4: Valid Complex String"); // Test case header
        String s4 = "(())())"; // Input: "(())())"
        int result4 = solution.minInsertions(s4); // Computes insertions
        displayTestResult(s4, result4); // Expected: 0

        // Test Case 5: All closing
        System.out.println("Test Case 5: All Closing"); // Test case header
        String s5 = ")))"; // Input: ")))"
        int result5 = solution.minInsertions(s5); // Computes insertions
        displayTestResult(s5, result5); // Expected: 3

        // Test Case 6: All opening
        System.out.println("Test Case 6: All Opening"); // Test case header
        String s6 = "((("; // Input: "((("
        int result6 = solution.minInsertions(s6); // Computes insertions
        displayTestResult(s6, result6); // Expected: 6

        // Test Case 7: Empty string
        System.out.println("Test Case 7: Empty String"); // Test case header
        String s7 = ""; // Input: ""
        int result7 = solution.minInsertions(s7); // Computes insertions
        displayTestResult(s7, result7); // Expected: 0

        // Test Case 8: Single parenthesis
        System.out.println("Test Case 8: Single Parenthesis"); // Test case header
        String s8 = ")"; // Input: ")"
        int result8 = solution.minInsertions(s8); // Computes insertions
        displayTestResult(s8, result8); // Expected: 2

    } // Summary: Tests minInsertions with examples, valid string, all closing, all opening, empty, and single parenthesis cases.
}