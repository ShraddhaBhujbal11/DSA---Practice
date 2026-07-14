/*
Problem: 167. Two Sum II - Input Array Is Sorted
Platform: LeetCode
Difficulty: Medium
Link:https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Since the array is sorted, use two pointers:
  - left starts at the beginning.
  - right starts at the end.
- Calculate the sum of the two numbers.
- If the sum equals the target:
  - Return their 1-based indices.
- If the sum is less than the target:
  - Move the left pointer to increase the sum.
- If the sum is greater than the target:
  - Move the right pointer to decrease the sum.
- The problem guarantees exactly one solution.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {};
    }
}
