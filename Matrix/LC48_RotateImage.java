/*
Problem: 48. Rotate Image
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/rotate-image/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Rotate the matrix in-place by performing two operations:
  1. Transpose the matrix:
     - Swap matrix[i][j] with matrix[j][i] for all j > i.
     - This converts rows into columns.
  2. Reverse each row:
     - Swap the first and last elements of every row.
     - Continue moving inward until the row is completely reversed.
- After these two steps, the matrix is rotated 90 degrees clockwise.

Time Complexity: O(n²)
Space Complexity: O(1)
*/

class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (left < right) {

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}
