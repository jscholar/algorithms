// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignorning cases.

class Solution {
    public boolean isPalindrome(String s) {
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        while (leftIndex <= rightIndex) {
            if (!isAlphanumeric(s.charAt(leftIndex))) {
                leftIndex++;
            } else if (!isAlphanumeric(s.charAt(rightIndex))) {
                rightIndex--;
            } else if (
                Character.toLowerCase(s.charAt(leftIndex)) != Character.toLowerCase(s.charAt(rightIndex))
            ) {
                return false;
            } else {
                leftIndex++;
                rightIndex--;
            }
        }
        return true;
    }
    
    private boolean isAlphanumeric(char c) {
        if (
               c >= 'a' && c <= 'z'
            || c >= 'A' && c <= 'Z'
            || c >= '0' && c <= '9'
        ) {
            return true;
        }
        return false;
    }
}