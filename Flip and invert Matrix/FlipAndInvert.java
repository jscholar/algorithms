class Solution {
	public static void main (String[] args) {
	}
  
  // 1 0 0, 0 0 1, 1 1 0
  
  public static int[][] flipMatrix(int[][] matrix) {
  // Iterate through each row in the matrix
  
  // [0, 0, 1]
  //  ^   
    for (int i = 0; i < matrix.length; i++) {
      // For each row, iterate over the first half of the elements
      int j;
      for (j = 0; j < matrix.length / 2; j++) {
        if (matrix[i][j] == matrix[i][(matrix[i].length - 1) - j]) {
          continue;
        }
        
        // Take the element, and move it to the flipped position and invert it
        matrix[i][(matrix[i].length - 1) - j] = Math.abs(matrix[i][j] - 1);
        
        // Take the mirrored position and move it to this position and invert.
        matrix[i][j] = matrix[i][(matrix[i].length - 1) - j];
      }
      // If this element is in the middle, then just invert it
      if (matrix[i].length % 2 != 0) {
        matrix[i][j] = Math.abs(matrix[i][j] - 1);
      }
    }
    return matrix;
  }
}