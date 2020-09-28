/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    let wordSet = new Set(wordList);
    
    if (wordSet.has(endWord)) {
        let words = new Set();
        let otherWords = new Set();
        words.add(beginWord);
        otherWords.add(endWord);
        
        let distance = 0;
        
        while (words.size > 0) {
            distance += 1;
            let nextWords = new Set();
            for (let word of words.values()) {
                if (otherWords.has(word)) {
                    return distance;
                }
                for (let nextWord of wordSet.values()) {
                    if (wordDistanceIsOne(word, nextWord)) {
                        nextWords.add(nextWord);
                        wordSet.delete(word);
                    }
                }
            }
            [words, otherWords] = [otherWords, nextWords];
        }
    }
    
    return 0;
};
    
const wordDistanceIsOne = (word1, word2) => {
    let distance = 0;
    for (let i = 0; i < word1.length; i++) {
        if (word1[i] !== word2[i]) {
            if (++distance > 1) {
                return false;
            }
        }
    }
    
    return distance === 1;
}