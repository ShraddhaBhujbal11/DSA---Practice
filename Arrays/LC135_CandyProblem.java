/*
Problem: 135. Candy
Platform: LeetCode
Difficulty: Hard
Link: https://leetcode.com/problems/candy/

Approach:
- Give every child 1 candy initially since each child must receive at least one candy.
- Traverse from left to right:
  - If the current child's rating is greater than the previous child's rating,
    assign one more candy than the previous child.
- Traverse from right to left:
  - If the current child's rating is greater than the next child's rating,
    update the current child's candies to the maximum of:
      - its current candies
      - one more than the next child's candies.
- Finally, sum all the candies and return the total.
- This ensures both left and right neighbor conditions are satisfied while
  minimizing the total number of candies.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] candies = new int[n];

        // Give every child one candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int totalCandies = 0;

        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}
