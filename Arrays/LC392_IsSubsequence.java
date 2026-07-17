/*
Problem: 392. Is Subsequence
Platform: LeetCode
Difficulty: Easy
Link: https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Use two pointers:
  - i for string s.
  - j for string t.
- Traverse string t from left to right.
- If the current characters of s and t match:
  - Move both pointers forward.
- Otherwise:
  - Move only the pointer in t.
- If all characters of s are matched, i reaches the end of s.
- Return true if i == s.length(), otherwise return false.

Time Complexity: O(n)
  - n = length of t
Space Complexity: O(1)
*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
