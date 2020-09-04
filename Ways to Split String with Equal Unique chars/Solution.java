class Solution {
    public int numSplits(String s) {
        Map<Character, Integer> left = new HashMap();
        Map<Character, Integer> right = new HashMap();
        int goodWays = 0;
        
        for (char c : s.toCharArray()) {
            right.put(c, right.getOrDefault(c, 0) + 1);
        }
        
        for (char c : s.toCharArray()) {
            left.put(c, left.getOrDefault(c, 0) + 1);
            right.put(c, right.get(c) - 1);
            if (right.get(c) == 0) {
                right.remove(c);
            }
            
            if (left.size() == right.size()) {
                goodWays += 1;
            }
            if (left.size() > right.size()) {
                break;
            }
        }
        
        return goodWays;
    }
}