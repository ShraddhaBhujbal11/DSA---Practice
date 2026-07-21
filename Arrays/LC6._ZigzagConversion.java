/*
Problem: 6. Zigzag Conversion
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- If numRows is 1 or greater than/equal to the string length, return the string as it is.
- Create an array of StringBuilders, one for each row.
- Traverse the string character by character.
- Maintain:
  - currentRow: the row where the current character should be placed.
  - goingDown: indicates whether we are moving downward or upward in the zigzag.
- Append each character to its corresponding row.
- When the first or last row is reached, reverse the direction.
- After processing all characters, concatenate all rows to form the final string.
- Return the resulting string.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {

            rows[currentRow].append(c);

            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
