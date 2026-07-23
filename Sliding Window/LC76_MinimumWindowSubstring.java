/*
Problem: 76. Minimum Window Substring
Platform: LeetCode
Difficulty: Hard
Link: https://leetcode.com/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Use the Sliding Window technique with two pointers:
  - left  : Start of the current window.
  - right : End of the current window.
- Store the frequency of every character in string t using a HashMap.
- Expand the window by moving the right pointer:
  - Decrease the frequency of the current character if it exists in the map.
  - If the character is still needed (count >= 0), increment the matched count.
- Once all characters of t are matched:
  - Try to shrink the window from the left.
  - Update the minimum window whenever a smaller valid window is found.
  - While removing a character:
      - Increase its frequency in the map.
      - If its count becomes positive, the window is no longer valid.
- Continue until the entire string is processed.
- Return the smallest valid substring found.
- If no valid window exists, return an empty string.

Time Complexity: O(m + n)
Space Complexity: O(k)
where k = number of distinct characters in t.
*/

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Store frequency of characters in t
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int matched = 0;

        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);

            if (map.containsKey(rightChar)) {

                map.put(rightChar, map.get(rightChar) - 1);

                if (map.get(rightChar) >= 0) {
                    matched++;
                }
            }

            while (matched == t.length()) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                if (map.containsKey(leftChar)) {

                    map.put(leftChar, map.get(leftChar) + 1);

                    if (map.get(leftChar) > 0) {
                        matched--;
                    }
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLength);
    }
}
