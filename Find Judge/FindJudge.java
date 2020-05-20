import java.io.*;
import java.util.*;

class MyCode {
	public static void main (String[] args) {
		int[][] town = new int[][]{{0, 1}, {1, 2}, {0, 2}};
    System.out.println(findJudge(town, 3));
	}
  
  public static int findJudge(int[][] trusts, int n) {
    // If there isn't enough trust to prove a judge, then there's no judge
    if (trusts.length < n - 1) {
      return -1;
    }
    
    // Create Set structure to store the number of people who trust each individual person, aka the judges
    Map<Integer, Integer> judges = new HashMap<>();
    // Prepopulate the set with each town member 1 - n, nobody trusts them yet.
    for (int i = 0; i < n; i++) {
      judges.put(i, 0);
    }
    
    // Iterate through all the trusts
    for (int i = 0; i < trusts.length; i++) {
      int truster = trusts[i][0];
      int trusted = trusts[i][1];
      // Immediately remove the trusting person from possible judges
      judges.remove(truster);
      
      // If the trusted person is still a potential judge
      if (judges.containsKey(trusted)) {
        // Increment the trusted person's trust by 1.
        judges.put(trusted, judges.get(trusted) + 1);
      }
    }
      
    // If there are no potential judges, return -1
    if (judges.size() == 0) {
      return -1;
    } else if (judges.size() > 1) {
    // If the set contains more than one potential judge, none of them are judges. return -1
      return -1;
    } else {
      // If there's one person who could be a judge, see if they're trusted by everyone (n-1 people)
      int judge = judges.keySet()[0];
      return judges.get(judge) == n - 1 ? judge : -1;
    }
  }
}