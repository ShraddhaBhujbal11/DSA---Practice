/*
Problem: 28. Find the Index of the First Occurrence in a String
Platform: LeetCode
Difficulty: Easy
Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Traverse every possible starting position in the haystack.
- For each position:
  - Compare characters of the needle one by one.
- If all characters match, return the current starting index.
- If no match is found after checking all positions, return -1.

Time Complexity: O((n - m + 1) * m)
Space Complexity: O(1)
*/

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i;
            }
        }

        return -1;
    }
}
