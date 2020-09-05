class Solution {
  public List<Integer> partitionLabels(String S) {
      int[] chars = new int[26];
      Set<Character> currentChars = new HashSet();
      
      List<Integer> partitions = new ArrayList();
      
      for (char c : S.toCharArray()) {
          chars[c - 'a']++;
      }
      
      int start = 0;
      
      for (int i = 0; i < S.length(); i++) {
          char c = S.charAt(i);
          if (!currentChars.contains(c)) {
              currentChars.add(c);
          }
          if (--chars[c - 'a'] == 0) {
              currentChars.remove(c);
          }
          if (currentChars.size() == 0) {
              partitions.add(i + 1 - start);
              start = i + 1;
          }
      }
      
      return partitions;
  }
}