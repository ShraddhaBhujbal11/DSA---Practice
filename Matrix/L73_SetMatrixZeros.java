/*
Problem: 73. Set Matrix Zeroes
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Use the first row and first column as markers to avoid using extra space.
- First, determine whether the first row or first column originally contains a zero.
- Traverse the rest of the matrix:
  - If matrix[i][j] is 0, mark its entire row and column by setting:
      matrix[i][0] = 0
      matrix[0][j] = 0
- Traverse the matrix again (excluding the first row and first column):
  - If either the row marker or column marker is 0,
    set the current cell to 0.
- Finally:
  - If the first row originally had a zero, set the entire first row to 0.
  - If the first column originally had a zero, set the entire first column to 0.
- This performs the operation in-place without allocating another matrix.

Time Complexity: O(m × n)
Space Complexity: O(1)
*/

class Solution {
    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first row contains any zero
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check if first column contains any zero
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Use first row and first column as markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set cells to zero based on markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out the first row if needed
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Zero out the first column if needed
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
