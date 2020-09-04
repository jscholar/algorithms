class Solution {
    public int minFlips(String target) {
        int switched = 0;
        int currentIndex = 0;
        for (; currentIndex < target.length(); currentIndex++) {
            if (
                switched % 2 == 0 && target.charAt(currentIndex) == '1'
                || switched % 2 != 0 && target.charAt(currentIndex) == '0'
            ) {
                switched++;
            }
        }
        return switched;
    }
}