/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/

public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        var mapNumberToIndex = new Dictionary<int, int>();
        for (int i = 0; i < nums.Length; i++) {
            var current = nums[i];
            var pair = target - current;
            if (mapNumberToIndex.ContainsKey(pair)) {
                return new int[] {mapNumberToIndex[pair], i};
            }
            mapNumberToIndex[current] = i;
        }
        return null;
    }
}

/*
    Time Complexity: O(n)
    Space Complexity: O(n)
*/