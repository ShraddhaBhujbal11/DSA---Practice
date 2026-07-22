/*
Problem: 36. Valid Sudoku
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/valid-sudoku/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Use three HashSets to keep track of the digits seen:
  - rows    : Stores unique values for each row.
  - cols    : Stores unique values for each column.
  - boxes   : Stores unique values for each 3 × 3 sub-box.
- Traverse every cell in the board.
- If the cell contains '.', skip it.
- Otherwise:
  - Create a unique key for the current row.
  - Create a unique key for the current column.
  - Create a unique key for the corresponding 3 × 3 box.
- If any of these keys already exists in the HashSet,
  the board is invalid, so return false.
- Otherwise, add all three keys to the HashSet.
- If the traversal completes without duplicates,
  return true.

Time Complexity: O(9²) = O(1)
Space Complexity: O(9²) = O(1)
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> seen = new HashSet<>();

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char current = board[row][col];

                if (current == '.') {
                    continue;
                }

                String rowKey = current + " in row " + row;
                String colKey = current + " in col " + col;
                String boxKey = current + " in box " + (row / 3) + "-" + (col / 3);

                if (seen.contains(rowKey) ||
                    seen.contains(colKey) ||
                    seen.contains(boxKey)) {
                    return false;
                }

                seen.add(rowKey);
                seen.add(colKey);
                seen.add(boxKey);
            }
        }

        return true;
    }
}
