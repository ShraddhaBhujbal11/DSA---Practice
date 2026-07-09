/*
Problem: 238. Product of Array Except Self
Platform: LeetCode
Difficulty: Medium

Approach:
- Traverse the array once to count the number of zeros and calculate the product of all non-zero elements.
- If there are more than one zero, every element in the result array is 0.
- If there is exactly one zero, only the index containing the zero gets the product of all non-zero elements.
- If there are no zeros, compute the result for each index by dividing the total product by the current element.
- This efficiently handles all possible cases based on the number of zeros.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int idx = -1;
        int zeros = 0;
        int n = nums.length;
        int product = 1;

        int[] res = new int[n];
        Arrays.fill(res, 0);

        // Count zeros and calculate product of non-zero elements
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeros++;
                idx = i;
            } else {
                product *= nums[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (zeros == 1) {
                res[idx] = product;
            }

            if (zeros == 0) {
                res[i] = product / nums[i];
            }

            if (zeros > 1) {
                return res;
            }
        }

        return res;
    }
}

/*
OR

Approach:
- Use the output array to store the prefix product for each index.
- Traverse from left to right and store the product of all elements before the current index.
- Traverse from right to left while maintaining a suffix product.
- Multiply the prefix product stored in the output array with the current suffix product.
- Update the suffix product after each iteration.
- This avoids using division and satisfies the O(1) extra space requirement (excluding the output array).

Time Complexity: O(n)
Space Complexity: O(1) (excluding the output array)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }
}
