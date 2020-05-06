public class Solution {
    public int FindNumbers(int[] nums) {
        var count = 0;
        foreach (int num in nums) {
            if (num.ToString().Length % 2 === 0) {
                count += 1;
            }
        }
        return count;
    }
}

/*
    Time Complexity:  O(n * l) where l is the average number of digits in each number.
    Space Complexity: O(1)
*/