var lengthOfLongestSubstring = function(s) {
  // Create two pointers for the beginning and end of our substring
  let begin = 0;
  let end = 0;
  // Create a set to keep track of the chars already in the substring
  const chars = new Set();
  // Initalize a variable for the max substring length
  let maxLength = 0;
  
  // Iterate the end pointer over the entire string
  for (end; end < s.length; end++) {
    // We hit a duplicate
    if (chars.has(s[end])) {
      // Increment the beginning pointer until the substring no longer contains the duplicate
      while (chars.has(s[end])) {
        // Remove characters from the set of existing characters
        chars.delete(s[begin]);
        begin++;
      }
      chars.add(s[end]);
      
    // We dont hit a duplicate
    } else {
      // Add the current character into our set
      chars.add(s[end]);
      // Update the max length of substring
      maxLength = Math.max(maxLength, chars.size);
    }
  }
  // return the max length
  return maxLength;
};
