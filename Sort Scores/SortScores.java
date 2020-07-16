// Given a max possible score, sort the array in O(n) time
public class Solution {

  public static int[] sortScores(int[] unorderedScores, int highestPossibleScore) {

      // sort the scores in O(n) time
      int[] scoreCounts = new int[highestPossibleScore + 1];
      
      for (int score : unorderedScores) {
          scoreCounts[score]++;
      }
      
      int[] orderedScores = new int[unorderedScores.length];
      int index = 0;
      
      for (int score = highestPossibleScore; score >= 0; score--) {
          for (int i = 0; i < scoreCounts[score]; i++) {
              orderedScores[index] = score;
              index++;
          }
      }

      return orderedScores;
  }
}