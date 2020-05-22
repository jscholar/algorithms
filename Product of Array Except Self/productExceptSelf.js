/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
  const result = new Array(nums.length).fill(1);
  let cur = 1;
  for (let i = 0; i < nums.length; i++) {
      result[i] *= cur;
      cur *= nums[i];
  }
  
  cur = 1;
  for (let i = nums.length - 1; i >= 0; i--) {
      result[i] *= cur;
      cur *= nums[i];
  }
  return result;
};