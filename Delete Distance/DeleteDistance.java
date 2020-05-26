class DeleteDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;
        for (int i = 0; i < word1.length() + 1; i++) {
            for (int j = 0; j < word2.length() + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        // No operations need take place, and the answer is the same as if these chars weren't there.
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // Delete one or the other, whichever leads to a less expensive substring
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                    }
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}