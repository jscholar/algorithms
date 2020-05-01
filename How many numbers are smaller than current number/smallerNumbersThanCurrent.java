class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        Map<Integer, Integer> lessThan = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < sorted.length; i++) {
            lessThan.putIfAbsent(sorted[i], i);
        }
        
        int[] res = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            res[i] = lessThan.get(nums[i]);
        }
        
        return res;
    }
}
