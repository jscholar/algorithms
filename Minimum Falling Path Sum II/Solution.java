class Solution {
  public int minFallingPathSum(int[][] arr) {
      // straightforward bottom-up dp
      
      // DP stores the minumum sum falling to that particular cell
      int[][] dp = new int[arr.length][arr[0].length];

      // We'll also remember the mins from the last row, to avoid repeated calculation
      int[] minLastRow = new int[] { 0, Integer.MAX_VALUE };
      int[] nextMinLastRow = new int[] { 0, Integer.MAX_VALUE };
      
      for (int col = 0; col < arr[0].length; col++) {
          dp[0][col] = arr[0][col];
          if (dp[0][col] < minLastRow[1]) {
              nextMinLastRow[0] = minLastRow[0];
              nextMinLastRow[1] = minLastRow[1];
              minLastRow[0] = col;
              minLastRow[1] = dp[0][col];
          } else if (dp[0][col] < nextMinLastRow[1]) {
              nextMinLastRow[0] = col;
              nextMinLastRow[1] = dp[0][col];
          }
      }

      for (int row = 1; row < arr.length; row++) {
          int[] minThisRow = new int[] { 0, Integer.MAX_VALUE };
          int[] nextMinThisRow = new int[] { 0, Integer.MAX_VALUE };
      
          for (int col = 0; col < arr[row].length; col++) {
              
              if (col != minLastRow[0]) {
                  dp[row][col] = arr[row][col] + minLastRow[1];
              } else {
                  dp[row][col] = arr[row][col] + nextMinLastRow[1];
              }
              
              if (dp[row][col] < minThisRow[1]) {
                  nextMinThisRow[0] = minThisRow[0];
                  nextMinThisRow[1] = minThisRow[1];
                  minThisRow[0] = col;
                  minThisRow[1] = dp[row][col];
              } else if (dp[row][col] < nextMinThisRow[1]) {
                  nextMinThisRow[0] = col;
                  nextMinThisRow[1] = dp[row][col];
              }
              
          }
          
          minLastRow = minThisRow;
          nextMinLastRow = nextMinThisRow;
      }
      
      return minLastRow[1];
  }
}