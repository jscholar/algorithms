import java.io.*;
import java.util.List;
import java.util.ArrayList;

class MyCode {
	public static void main (String[] args) {
	}
  
    public static List<List<Integer>> subsets(int[] nums) {
      // Initialize the base powerset (which includes the empty set)
      List<List<Integer>> powerset = new ArrayList<>();
      List<Integer> emptySet = new ArrayList<>();
      powerset.add(emptySet);
      // Iterate through our input
      for (int i = 0; i < nums.length; i++) {
        // For each of the integers, we'll create new subsets from our existing ones
        // Creating the powersets of the partial array we've iterated over so far.
        int current = nums[i];
        int n = powerset.size();
        for (int j = 0; j < n; j++) {
          List<Integer> subset = new ArrayList<Integer>(powerset.get(j));
          subset.add(current);
          powerset.add(subset);
        }
      }
      return powerset;
    }
}
