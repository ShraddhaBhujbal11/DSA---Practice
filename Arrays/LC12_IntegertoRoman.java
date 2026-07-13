/*
Problem: 12. Integer to Roman
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Store all possible Roman numeral values and their corresponding symbols in
  descending order, including the six subtractive forms (IV, IX, XL, XC, CD, CM).
- Traverse the values array from largest to smallest.
- While the current value is less than or equal to the number:
  - Append the corresponding Roman symbol to the result.
  - Subtract the value from the number.
- Continue until the number becomes 0.
- Return the constructed Roman numeral.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {
    public String intToRoman(int num) {
        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };

        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }
}
