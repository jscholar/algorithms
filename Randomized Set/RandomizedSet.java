/*

Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

*/

class RandomizedSet {
    private Map<Integer, Integer> set;
    private ArrayList<Integer> list;
    private int size;
    private Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        // We'll use a HashMap in conjunction with a set, since they have near constant lookup and deletion
        // The keys of the map will be useful to get a random item
        list = new ArrayList();
        set = new HashMap();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (set.containsKey(val)) {
            return false;
        }
        set.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!set.containsKey(val)) {
            return false;
        }
        // Replace deleted with last element in the array, pop the last element off
        int index = set.get(val);
        if (index != list.size() - 1) {
            list.set(index, list.get(list.size() - 1));
            set.put(list.get(index), index);
        }
        list.remove(list.size() - 1);
        set.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}