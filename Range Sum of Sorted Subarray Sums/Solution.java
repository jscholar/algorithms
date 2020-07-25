public class Solution {
  public int rangeSum(int[] nums, int n, int left, int right) {
    int[] prefixSums = new int[n + 1];
    for (int index = 1; index < prefixSums.length; index++) {
        prefixSums[index] = prefixSums[index - 1] + nums[index - 1];
    }
    
    int[] arraySums = new int[n * (n + 1) / 2];
    int index = 0;
    for (int begin = 0; begin < n; begin++) {
        for (int end = begin + 1; end < n + 1; end++) {
            arraySums[index] = prefixSums[end] - prefixSums[begin];
            index++;
        }
    }
    
    Arrays.sort(arraySums);
    
    int sum = 0;
    left -= 1;
    for (; left < right; left++) {
        sum = (sum + arraySums[left]) % 1000000007;
    }
    
    
    return sum;
  }
}