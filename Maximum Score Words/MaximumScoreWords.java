class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] bucket = new int[26];
        for (char c : letters) {
            bucket[c - 'a'] += 1;
        }
        int[][] wordBuckets = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (int c = 0; c < words[i].length(); c++) {
                wordBuckets[i][words[i].charAt(c) - 'a']++;
            }
        }
        
        int[] wordScores = new int[words.length];
        for (int i = 0; i < wordBuckets.length; i++) {
            for (int j = 0; j < wordBuckets[i].length; j++) {
                wordScores[i] += wordBuckets[i][j] * score[j];
            }
        }
            
        return helper(wordBuckets, bucket, wordScores, 0);
    }
    
    private int helper(int[][] wordBuckets, int[] bucket, int[] wordScores, int start) {
        int max = 0;
        for (int i = start; i < wordBuckets.length; i++) {
            int score = 0;
            if (canMakeWord(wordBuckets[i], bucket)) {
                editLetters(wordBuckets[i], bucket, false);
                score += wordScores[i];
                score += helper(wordBuckets, bucket, wordScores, i + 1);
                max = Math.max(max, score);
                editLetters(wordBuckets[i], bucket, true);
            }
        }
        return max;
    }
    
    private boolean canMakeWord(int[] wordBucket, int[] bucket) {
        for (int i = 0; i < bucket.length; i++) {
            if (wordBucket[i] > bucket[i]) {
                return false;
            }
        }
        return true;
    }
    
    private void editLetters(int[] wordBucket, int[] bucket, boolean add) {
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] += wordBucket[i] * (add ? 1 : -1);
        }
    }
}