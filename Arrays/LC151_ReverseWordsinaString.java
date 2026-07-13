/*
Problem: 151. Reverse Words in a String
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Remove leading and trailing spaces using trim().
- Split the string into words using one or more spaces as the delimiter.
- Traverse the words array from the end to the beginning.
- Append each word to a StringBuilder.
- Add a single space between words (except after the last word).
- Return the reversed string.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);

            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
