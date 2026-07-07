/*
Problem: 27. Remove Element
Platform: LeetCode
Difficulty: Easy
Link : https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Use two pointers:
  - i starts from the beginning of the array.
  - j starts from the end of the array.
- If nums[i] equals the target value (val), replace it with nums[j] and decrement j.
- Do not increment i after replacement because the new element at index i needs to be checked.
- If nums[i] is not equal to val, simply move i forward.
- The valid portion of the array is from index 0 to j, so the new length is j + 1.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        int i = 0;

        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }

        return j + 1;
    }
}
