public class PermutationPalindrome {

  public static boolean hasPalindromePermutation(String str) {
    // There may only be one character at most to appear an odd number of times
    // for this to be true.

    Set<Character> chars = new HashSet();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (chars.contains(c)) {
        chars.remove(c);
      } else {
        chars.add(c);
      }
    }

    return chars.size() <= 1;
  }
}