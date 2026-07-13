/*
Problem: 14. Longest Common Prefix
Platform: LeetCode
Difficulty: Easy
Link: https://leetcode.com/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Assume the first string is the common prefix.
- Compare the prefix with each remaining string.
- While the current string does not start with the prefix:
  - Remove the last character from the prefix.
- If the prefix becomes empty, return an empty string.
- After processing all strings, the remaining prefix is the longest common prefix.

Time Complexity: O(n * m)
  - n = number of strings
  - m = length of the shortest common prefix
Space Complexity: O(1)
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
