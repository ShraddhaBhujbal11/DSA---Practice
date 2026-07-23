/*
Problem: 30. Substring with Concatenation of All Words
Platform: LeetCode
Difficulty: Hard
Link: https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Let:
  - wordLength = length of each word.
  - wordCount = total number of words.
  - windowSize = wordLength * wordCount.
- Store the frequency of each word in a HashMap (targetMap).
- Since all words have the same length, process the string for each possible
  starting offset (0 to wordLength - 1).
- Use a sliding window that moves one word at a time:
  - right extracts one word and adds it to the current window map.
  - If a word appears more times than allowed:
      - Shrink the window from the left until the frequency becomes valid.
  - If an invalid word is encountered:
      - Clear the current window and restart after that word.
  - Whenever the window contains exactly wordCount words,
    record the starting index.
- Continue until the entire string is processed.

Time Complexity: O(n × wordLength)
Space Complexity: O(k)
where k = number of distinct words.
*/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;

        HashMap<String, Integer> targetMap = new HashMap<>();

        for (String word : words) {
            targetMap.put(word, targetMap.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordLength; offset++) {

            int left = offset;
            int count = 0;

            HashMap<String, Integer> windowMap = new HashMap<>();

            for (int right = offset;
                 right + wordLength <= s.length();
                 right += wordLength) {

                String word = s.substring(right, right + wordLength);

                if (targetMap.containsKey(word)) {

                    windowMap.put(word,
                            windowMap.getOrDefault(word, 0) + 1);

                    count++;

                    while (windowMap.get(word) > targetMap.get(word)) {

                        String leftWord =
                                s.substring(left, left + wordLength);

                        windowMap.put(leftWord,
                                windowMap.get(leftWord) - 1);

                        left += wordLength;
                        count--;
                    }

                    if (count == wordCount) {

                        result.add(left);

                        String leftWord =
                                s.substring(left, left + wordLength);

                        windowMap.put(leftWord,
                                windowMap.get(leftWord) - 1);

                        left += wordLength;
                        count--;
                    }

                } else {

                    windowMap.clear();
                    count = 0;
                    left = right + wordLength;
                }
            }
        }

        return result;
    }
}
