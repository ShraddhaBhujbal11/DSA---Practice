/*
Problem: 242. Valid Anagram
Platform: LeetCode
Difficulty: Easy
Link: https://leetcode.com/problems/valid-anagram/?envType=study-plan-v2&envId=top-interview-150

Approach:
- If the lengths of the two strings are different, they cannot be anagrams.
- Create an integer array of size 26 to store the frequency of each lowercase letter.
- Traverse both strings simultaneously:
  - Increment the count for each character in string s.
  - Decrement the count for each character in string t.
- After traversal, check the frequency array:
  - If every value is 0, both strings contain the same characters with the same frequencies.
  - Otherwise, they are not anagrams.
- Return the result.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int freq : count) {
            if (freq != 0) {
                return false;
            }
        }

        return true;
    }
}
