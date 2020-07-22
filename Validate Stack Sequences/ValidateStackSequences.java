class Solution {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
      Stack<Integer> stack = new Stack();
      
      int pushedIndex = 0;
      int poppedIndex = 0;
      
      while (pushedIndex < pushed.length) {
          stack.push(pushed[pushedIndex]);
          pushedIndex++;
          while (!stack.empty() && stack.peek() == popped[poppedIndex]) {
              stack.pop();
              poppedIndex++;
          }
      }
      
      return poppedIndex == popped.length;

  }
}