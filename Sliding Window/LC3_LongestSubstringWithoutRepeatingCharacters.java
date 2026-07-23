/*
Problem: 3. Longest Substring Without Repeating Characters
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Use the Sliding Window technique with two pointers:
  - left  : Start of the current window.
  - right : End of the current window.
- Use a HashSet to store the unique characters in the current window.
- Traverse the string using the right pointer.
- If the current character is not present in the HashSet:
  - Add it to the HashSet.
  - Update the maximum window length.
  - Move the right pointer forward.
- If the current character already exists:
  - Remove characters from the left side of the window until the duplicate
    character is removed.
  - Move the left pointer accordingly.
- Continue until the entire string is processed.
- Return the maximum length found.

Time Complexity: O(n)
Space Complexity: O(min(n, charset))
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
