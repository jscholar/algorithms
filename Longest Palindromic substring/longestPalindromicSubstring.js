/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    let longest = '';
    for (let i = 0; i < s.length; i++) {
        let palindrome = expandPalindrome(s, i, i);
        if (palindrome.length > longest.length) {
            longest = palindrome;
        }
        
        palindrome = expandPalindrome(s, i, i + 1);
        if (palindrome.length > longest.length) {
            longest = palindrome;
        }
    }
    return longest;
};

const expandPalindrome = (s, begin, end) => {
    while (begin >= 0 && end < s.length && s[begin] === s[end]) {
        begin -= 1;
        end += 1;
    }
    
    return s.slice(begin + 1, end);
}