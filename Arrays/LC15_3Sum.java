/*
Problem: 15. 3Sum
Platform: LeetCode
Difficulty: Medium
Link: https://leetcode.com/problems/3sum/?envType=study-plan-v2&envId=top-interview-150

Approach:
- Sort the array.
- Fix one element at a time using index i.
- For each fixed element, use two pointers:
  - left starts at i + 1.
  - right starts at the end of the array.
- Calculate the sum of nums[i] + nums[left] + nums[right].
  - If the sum is 0:
      - Add the triplet to the result.
      - Move both pointers inward.
      - Skip duplicate values for left and right pointers.
  - If the sum is less than 0:
      - Move left forward to increase the sum.
  - If the sum is greater than 0:
      - Move right backward to decrease the sum.
- Skip duplicate values for the fixed element (i) to avoid duplicate triplets.
- Continue until all possible triplets are checked.
- Return the list of unique triplets.

Time Complexity: O(n²)
Space Complexity: O(1)   // Excluding the output list
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    // Skip duplicate second elements
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate third elements
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
