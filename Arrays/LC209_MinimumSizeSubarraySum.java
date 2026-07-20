/*
Problem: 209. Minimum Size Subarray Sum
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Use the Sliding Window technique since all elements are positive.
- Maintain two pointers:
  - left = start of the current window.
  - right = end of the current window.
- Expand the window by moving the right pointer and add nums[right] to the sum.
- Whenever the current sum becomes greater than or equal to the target:
  - Update the minimum length of the valid window.
  - Shrink the window from the left by subtracting nums[left] from the sum.
  - Move left forward to check if a smaller valid window exists.
- Continue until the right pointer reaches the end of the array.
- If no valid subarray is found, return 0; otherwise, return the minimum length.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);

                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
