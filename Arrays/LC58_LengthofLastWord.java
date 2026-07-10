/*
Problem: 58. Length of Last Word
Platform: LeetCode
Difficulty: Easy
Link: https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Start traversing the string from the end.
- Skip all trailing spaces.
- Count the characters of the last word until a space or the beginning of the string is reached.
- Return the count.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
