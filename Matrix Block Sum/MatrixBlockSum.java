// Given a m * n matrix mat and an integer K,
// return a matrix answer where each answer[i][j] is the sum
// of all elements mat[r][c] for i - K <= r <= i + K, j - K <= c <= j + K,
// and (r, c) is a valid position in the matrix.

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        // Create a prefix matrix where the m[i][j] is the sum of the submatrix
        // for all elements mat[a][b] where a <= i and b <= j
        int[][] prefix = new int[mat.length][mat[0].length];
        int[][] result = new int[mat.length][mat[0].length];
        
        for (int i = 0; i < mat.length; i++) {
            prefix[i][0] = mat[i][0];
            for (int j = 1; j < mat[i].length; j++) {
                prefix[i][j] = prefix[i][j-1] + mat[i][j];
            }
        }
        
        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                prefix[i][j] += prefix[i-1][j];
            }
        }
        
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                // The desired sum is the sum of all elements in a square submatrix
                // Take the bottom right corner, which will contain the sum of all relevant elements in the matrix block,
                // plus some irrelevant elements
                int bottom = Math.min(mat.length - 1, i + K);
                int right = Math.min(mat[i].length - 1, j + K);
                
                int sum = prefix[bottom][right];
                // Subtract the irrelevant submatrices
                if (i - K > 0) {
                    sum -= prefix[(i - K) - 1][right];
                }
                
                if (j - K > 0) {
                    sum -= prefix[bottom][(j - K) - 1];
                }
                
                // Top left submatrix is removed twice. Add one back in.
                if (j - K > 0 && i - K > 0) {
                    sum += prefix[(i - K) - 1][(j - K) - 1];
                }
                
                result[i][j] = sum;
            }
        }
        
        return result;
    }
}