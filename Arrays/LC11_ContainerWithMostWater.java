/*
Problem: 11. Container With Most Water
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Use two pointers:
  - left starts at the beginning.
  - right starts at the end.
- Calculate the area formed by the two lines:
  - width = right - left
  - height = minimum of the two heights
  - area = width * height
- Update the maximum area found so far.
- Move the pointer pointing to the shorter line:
  - Moving the taller line cannot increase the area because the height is
    limited by the shorter line while the width decreases.
- Continue until the two pointers meet.
- Return the maximum area.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int area = width * currentHeight;

            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
