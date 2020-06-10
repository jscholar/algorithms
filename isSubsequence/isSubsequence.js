/*
  Given a string s and a string t, check if s is subsequence of t.

  A subsequence of a string is a new string which is formed from the original string 
  by deleting some (can be none) of the characters without disturbing the
  relative positions of the remaining characters.
  (ie, "ace" is a subsequence of "abcde" while "aec" is not).
*/

var isSubsequence = function(s, t) {
  if (s === "") {
      return true;
  }
  
  let i = 0;
  let j = -1;
  
  while (t.length - ++j >= s.length - i) {
      if (s[i] === t[j] && ++i === s.length) return true;
  }
      
  return false;
};