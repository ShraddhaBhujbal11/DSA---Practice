/*
Problem: 289. Game of Life
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/game-of-life/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Since all cells must be updated simultaneously, we cannot immediately change
  a cell's value because it would affect the neighbor calculations.
- Use temporary states:
  - -1 : Cell was alive (1) and will become dead (0).
  -  2 : Cell was dead (0) and will become alive (1).
- For each cell:
  - Count its live neighbors.
  - Treat both 1 and -1 as originally alive.
  - Apply the Game of Life rules:
      - Live cell with < 2 or > 3 live neighbors → mark as -1.
      - Dead cell with exactly 3 live neighbors → mark as 2.
- After processing all cells:
  - Convert:
      - -1 → 0
      -  2 → 1
- This updates the board in-place without using another matrix.

Time Complexity: O(m × n)
Space Complexity: O(1)
*/

class Solution {

    // 8 possible directions
    private final int[][] directions = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1},           {0, 1},
        {1, -1},  {1, 0},  {1, 1}
    };

    public void gameOfLife(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        // First pass: Mark transitions
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                int liveNeighbors = 0;

                for (int[] dir : directions) {

                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < rows &&
                        newCol >= 0 && newCol < cols &&
                        Math.abs(board[newRow][newCol]) == 1) {

                        liveNeighbors++;
                    }
                }

                if (board[row][col] == 1) {

                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[row][col] = -1; // Alive -> Dead
                    }

                } else {

                    if (liveNeighbors == 3) {
                        board[row][col] = 2; // Dead -> Alive
                    }
                }
            }
        }

        // Second pass: Finalize the board
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
}
