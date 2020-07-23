public class KthMissingElementSortedArray {
  public int kthMissing(int[] arr, int k) {
    for (int index = 0; index < arr.length - 1; index++) {
      // Is the missing number between the next two?
      int missingNumbers = (arr[index + 1] - arr[index]) - 1;
      k -= missingNumbers;
      if (k <= 0) {
        return arr[index + 1] + (k - 1);
      }
    }
    return arr[arr.length - 1] + k;
  }
}