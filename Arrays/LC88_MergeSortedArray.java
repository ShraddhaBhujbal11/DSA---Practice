/*
Problem: 88. Merge Sorted Array
Platform: LeetCode
Difficulty: Easy
Link : https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Use three pointers starting from the end of the arrays.
- i points to the last valid element in nums1.
- j points to the last element in nums2.
- k points to the last position in nums1.
- Compare nums1[i] and nums2[j], placing the larger element at nums1[k].
- Move the corresponding pointer and decrement k.
- After one array is exhausted, copy any remaining elements from nums2 into nums1.
- No need to copy remaining elements from nums1, as they are already in the correct position.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
