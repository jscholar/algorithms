// Given a non-empty string check if it can be constructed by taking a substring of it
// and appending multiple copies of the substring together.
// You may assume the given string consists of lowercase English letters only
// and its length will not exceed 10000.

class Solution {
  public boolean repeatedSubstringPattern(String s) {
      for (int i = 1; i < s.length(); i++) {
          if (s.length() % i == 0) {
              if (repeatSubstringOfLength(s, i)) {
                  return true;
              }
          }
      }
      
      return false;
  }
  
  private boolean repeatSubstringOfLength(String s, int k) {
      String match = s.substring(0, k);
      for (int i = 0; i < s.length() / k; i++) {

          if (!match.equals(s.substring(i * k, (i + 1) * k))) {
              return false;
          }
      }
      return true;
  }
}