/*
Problem: 125. Valid Palindrome
Platform: LeetCode
Difficulty: Easy
Link: https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Use two pointers:
  - left starts from the beginning.
  - right starts from the end.
- Skip characters that are not letters or digits.
- Convert both valid characters to lowercase before comparing.
- If the characters are different, return false.
- Otherwise, move both pointers inward.
- If all corresponding characters match, return true.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
