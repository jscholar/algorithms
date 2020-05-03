class GroupByGroupSize {
    public List<List<Integer>> groupByGroupSize(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<List<Integer>> groups = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> group = map.computeIfAbsent(groupSizes[i], k -> new ArrayList<Integer>());
            
            group.add(i);
            
            if (group.size() == groupSizes[i]) {
                // Group has been filled
                groups.add(group);
                map.remove(groupSizes[i]);
            }
        }
        
        return groups;
    }
}
