// Essentially the two-sum problem
public class InflightEntertainment {
  public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength)
  {
    Set<Integer> set = new HashSet();
    for (int length : movieLengths) {
      if (set.contains(flightLength - movieLength)) {
        return true;
      }
      set.add(length);
    }
    return false;
  }
}