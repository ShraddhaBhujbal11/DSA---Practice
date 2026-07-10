/*
Problem: 13. Roman to Integer
Platform: LeetCode
Difficulty: Easy
Link: https://leetcode.com/problems/roman-to-integer/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Traverse the Roman numeral from left to right.
- Convert each Roman symbol to its corresponding integer value.
- If the current value is less than the next value, it represents a subtraction case
  (e.g., IV = 4, IX = 9), so subtract the current value from the total.
- Otherwise, add the current value to the total.
- Return the final total.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int romanToInt(String s) {
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = value(s.charAt(i));

            if (i < s.length() - 1 && current < value(s.charAt(i + 1))) {
                total -= current;
            } else {
                total += current;
            }
        }

        return total;
    }

    private int value(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
