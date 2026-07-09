/*
Problem: 42. Trapping Rain Water
Platform: LeetCode
Difficulty: Hard
Link : https://leetcode.com/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Use the two-pointer technique with pointers at the beginning and end of the array.
- Maintain the maximum height seen so far from the left (leftMax) and right (rightMax).
- Compare the heights at both pointers:
  - If the left height is smaller, the trapped water depends on leftMax.
    - If the current height is greater than or equal to leftMax, update leftMax.
    - Otherwise, add (leftMax - current height) to the total trapped water.
    - Move the left pointer forward.
  - Otherwise, the trapped water depends on rightMax.
    - If the current height is greater than or equal to rightMax, update rightMax.
    - Otherwise, add (rightMax - current height) to the total trapped water.
    - Move the right pointer backward.
- Continue until the two pointers meet.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }
}
