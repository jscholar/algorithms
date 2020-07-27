class Solution {
  int[][] directions = new int[][] {
      new int[] { 1, 0 },
      new int[] { 0, 1 },
      new int[] { -1, 0 },
      new int[] { 0, -1 }
  };
  
  public int uniquePathsIII(int[][] grid) {
      int startRow = 0;
      int startCol = 0;
      
      int cellsLeft = 0;
      
      
      
      for (int row = 0; row < grid.length; row++) {
          for (int col = 0; col < grid[row].length; col++) {
              if (grid[row][col] == 1) {
                  startRow = row;
                  startCol = col;
              }
              if (grid[row][col] != -1) {
                  cellsLeft += 1;
              }
          }
      }
      
      return nextCell(startRow, startCol, grid, cellsLeft);
  }

  private int nextCell(int row, int col, int[][] grid, int cellsLeft) {
      // Out of bounds or hit obstacle. Stop searching
      if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == -1) {
          return 0;
      }
      
      cellsLeft -= 1;
      int square = grid[row][col];
      grid[row][col] = -1;
      int paths = 0;
      
      // Reached the end square
      if (square == 2)
      {
          if (cellsLeft == 0) {
              paths = 1;
          }
      }
      else
      {
          for (int[] direction : directions) {
              paths += nextCell(row + direction[0], col + direction[1], grid, cellsLeft);
          }
      }
      
      cellsLeft += 1;     
      grid[row][col] = square;
      return paths;
  }
}