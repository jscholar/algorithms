class Solution {
  public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> frequencyMap = new HashMap();
      for (int num : nums) {
          frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
      }
      
      Queue<Integer> heap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
      
      for (int num : frequencyMap.keySet()) {
          heap.add(num);
      }
      
      int[] topK = new int[k];
      
      for (int i = 0; i < k; i++) {
          topK[i] = heap.poll();
      }
      
      return topK;
  }
}