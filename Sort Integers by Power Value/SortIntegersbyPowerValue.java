class Solution {
    private Map<Integer, Integer> dp = new HashMap();
    {
        dp.put(1, 0);
    }
    public int getKth(int lo, int hi, int k) {
        int[][] powers = new int[1 + hi - lo][2];
        for (int i = lo; i <= hi; i++) {
            powers[i-lo][0] = i;
            powers[i-lo][1] = getPower(i);
        }
        Arrays.sort(powers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });
        return powers[k - 1][0];
    }
    
    private int getPower(int x) {
        if (!dp.containsKey(x)) {
            if (x % 2 == 0) {
                dp.put(x, 1 + getPower(x / 2));
            } else {
                dp.put(x, 1 + getPower(3 * x + 1));
            }
        }
        return dp.get(x);
    }
}