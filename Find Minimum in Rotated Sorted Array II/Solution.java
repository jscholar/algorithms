public class Solution {
  public int findMin(int[] nums) { 
    if (nums.length == 1) {
        return nums[0];
    }
    
    if (nums[0] < nums[nums.length - 1]) {
        return nums[0];
    }
    
    return binarySearch(nums, 0, nums.length - 1);
  }

  private int binarySearch(int[] nums, int left, int right) {
      if (right - left <= 1) {
          return nums[left + 1];
      }
      
      int mid = (right + left) / 2;
      if (nums[mid] < nums[right]) {
          return binarySearch(nums, left, mid);
      } else if (nums[mid] > nums[left]) {
          return binarySearch(nums, mid, right);
      } else {
          return Math.min(binarySearch(nums, left, mid), binarySearch(nums, mid, right));
      }
  }
}