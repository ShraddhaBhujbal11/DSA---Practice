/*
Problem: 26. Remove Duplicates from Sorted Array
Platform: LeetCode
Difficulty: Easy
Link : https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Since the array is sorted, duplicate elements are adjacent.
- Use two pointers:
  - i points to the last unique element.
  - j scans the array from left to right.
- If nums[j] is different from nums[i], a new unique element is found.
- Increment i and place nums[j] at nums[i].
- After processing all elements, the first (i + 1) positions contain all unique elements.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int n = nums.length;

        for (int j = 1; j < n; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
