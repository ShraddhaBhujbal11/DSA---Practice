/*
Problem: 54. Spiral Matrix
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/spiral-matrix/

Approach:
- Maintain four boundaries:
  - top    : first unvisited row.
  - bottom : last unvisited row.
  - left   : first unvisited column.
  - right  : last unvisited column.
- Traverse the matrix in four directions:
  1. Left → Right across the top row.
  2. Top → Bottom along the right column.
  3. Right → Left across the bottom row (if top <= bottom).
  4. Bottom → Top along the left column (if left <= right).
- After completing each direction, move the corresponding boundary inward.
- Continue until all boundaries cross.
- Return the list containing the elements in spiral order.

Time Complexity: O(m × n)
Space Complexity: O(1)   // Excluding the output list
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Traverse Left -> Right
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // Traverse Top -> Bottom
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // Traverse Right -> Left
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // Traverse Bottom -> Top
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }
}
