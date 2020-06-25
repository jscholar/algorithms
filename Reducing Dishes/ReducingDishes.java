class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int total = 0;
        int prefixSum = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            prefixSum += satisfaction[i];
            if (prefixSum < 0) {
                break;
            }
            total += prefixSum;
        }
        return total;
    }
}
