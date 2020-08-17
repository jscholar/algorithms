class Solution {
  public List<String> generateParenthesis(int n) {
      List<String> strings = new ArrayList();
      builder("", strings, 0, 2 * n);
      return strings;
  }
  
  private void builder(String current, List<String> strings, int open, int n) {
      if (current.length() == n) {
          strings.add(current);
          return;
      }
      if (open < n - current.length()) {
          builder(current + '(', strings, open + 1, n);
      }
      if (open > 0) {
          builder(current + ')', strings, open - 1, n);
      }
  }
}