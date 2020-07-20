class KthLargest {
  final int k;
  final PriorityQueue<Integer> pq;
  public KthLargest(int k, int[] nums) {
      this.k = k;
      pq = new PriorityQueue(k);
      for (int num : nums) {
          add(num);
      }
  }
  
  public int add(int n) {
      if (pq.size() < k)
          pq.offer(n);
      
      // Replace with largest elements
      else if (pq.peek() < n) {
          pq.poll();
          pq.offer(n);
      }
      
      return pq.peek();
  }
}
