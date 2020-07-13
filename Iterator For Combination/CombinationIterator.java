class CombinationIterator {
    String chars;
    int length;
    int[] comb;
    boolean calculatedNext;
    boolean end;
    
    public CombinationIterator(String characters, int combinationLength) {
        chars = characters;
        length = combinationLength;
        comb = new int[length];
        for (int i = 0; i < length; i++) {
            comb[i] = i;
        }
        calculatedNext = true;
        end = false;
    }
    
    public String next() {
        if (!calculatedNext) {
            hasNext();
        }
        calculatedNext = false;
        return combToString();
    }
    
    public boolean hasNext() {
        if (end) {
            return false;
        }
        if (calculatedNext) {
            return true;
        }
        int i = length - 1;
        while (i >= 0 && ++comb[i] + ((length - 1) - i) >= chars.length()) {
            i--;
        }
        i++;
        if (i == 0) {
            end = true;
            return false;
        }
        while (i < length) {
            comb[i] = comb[i - 1] + 1;
            i++;
        }
        calculatedNext = true;
        return true;
    }
    
    private String combToString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < comb.length; i++) {
            str.append(chars.charAt(comb[i]));
        }
        return str.toString();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
