/*
Problem: 274. H-Index
Platform: LeetCode
Difficulty: Medium
Link : https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Sort the citations array in ascending order.
- Traverse the sorted array from left to right.
- For each paper, calculate the number of papers having at least that many citations:
  - papers = n - i
- If citations[i] >= papers, then papers is a valid h-index.
- Return the first such value found.
- If no valid h-index exists, return 0.

Time Complexity: O(n log n)
Space Complexity: O(1) or O(log n) depending on the sorting implementation
*/

import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int papers = n - i;

            if (citations[i] >= papers) {
                return papers;
            }
        }

        return 0;
    }
}
