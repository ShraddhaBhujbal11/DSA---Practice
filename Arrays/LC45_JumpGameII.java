/*
Problem: 45. Jump Game II
Platform: LeetCode
Difficulty: Medium
Link : https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Use a greedy approach to find the minimum number of jumps.
- Maintain three variables:
  - maxReach: The farthest index that can be reached from the current jump range.
  - end: The end of the current jump range.
  - jumps: The number of jumps taken so far.
- Traverse the array (excluding the last index) and update maxReach.
- When the current index reaches the end of the current range, increment the jump count and update the range to maxReach.
- Continue until the last index is reachable.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int end = 0;
        int maxReach = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == end) {
                jumps++;
                end = maxReach;
            }
        }

        return jumps;
    }
}
