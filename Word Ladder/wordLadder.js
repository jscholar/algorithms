/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
    let wordSet = new Set(wordList);
    wordSet.delete(beginWord);
    let words = [beginWord];
    let distance = 0;
    if (wordSet.has(endWord)) {
        while (words.length > 0) {
            distance += 1;
            const n = words.length;
            let nextWords = [];
            for (let wordIndex = 0; wordIndex < n; wordIndex++) {
                let word = words[wordIndex];
                if (word === endWord) {
                    return distance;
                }
                for (let nextWord of wordSet.values()) {
                    if (wordDistanceIsOne(word, nextWord)) {
                        nextWords.push(nextWord);
                        wordSet.delete(nextWord);
                    }
                }
            }
            words = nextWords;
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