class Solution {
  public int subarraySum(int[] nums, int k) {        
      Map<Integer, Integer> seen = new HashMap();
      int count = 0;
      int sum = 0;
      seen.put(0, 1);
      for (int i = 0; i < nums.length; i++) {
          sum += nums[i];
          if (seen.containsKey(sum - k)) {
              count += seen.get(sum - k);
          }
          seen.put(sum, seen.getOrDefault(sum, 0) + 1);
      }
      
      return count;

  }
}