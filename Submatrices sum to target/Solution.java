class Solution {
  public int numSubmatrixSumTarget(int[][] mat, int target) {
      int[][] prefix = new int[mat.length][mat[0].length];
      for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < mat[0].length; j++) {
            prefix[i][j] += mat[i][j];
            if (j > 0) {
                prefix[i][j] += prefix[i][j - 1];
            }
        }
      }

      Map<Integer, Integer> seen = new HashMap();
      int count = 0;

      for (int col1 = 0; col1 < prefix[0].length; col1++) {
        for (int col2 = col1; col2 < prefix[0].length; col2++) {
            seen.clear();
            seen.put(0, 1);
            int sum = 0;
            for (int row = 0; row < prefix.length; row++) {
                sum += prefix[row][col2] - (col1 > 0 ? prefix[row][col1 - 1] : 0);
                if (seen.containsKey(sum - target)) {
                    count += seen.get(sum - target);
                }
                seen.put(sum, seen.getOrDefault(sum, 0) + 1);
            }
        }
      }

      return count;
  }
}