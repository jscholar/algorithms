/*
  Given a n x n matrix where each of the rows and columns are sorted in ascending order,
  find the kth smallest element in the matrix.
*/

class Solution {
  public int kthSmallest(int[][] matrix, int k) {
      PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(
          (c1, c2) -> matrix[c1[0]][c1[1]] - matrix[c2[0]][c2[1]]
      );
      
      for (int row = 0; row < matrix.length; row++) {
          minHeap.add(new int[] { row, 0 });
      }
      
      for (int i = 0; i < k - 1; i++) {
          int[] smallest = minHeap.poll();
          if (smallest[1] < matrix[smallest[0]].length - 1) {
              smallest[1] += 1;
              minHeap.add(smallest);
          }
      }
      int[] cell = minHeap.poll();
      return matrix[cell[0]][cell[1]];
  }
}