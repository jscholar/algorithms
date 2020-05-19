class WordDictionary {
  storage = {};
  /**
   * I: String
   * return void
   */
  addWord(word) {
    // Initialize a node starting at storage
    let node = this.storage;
    // Iterate through the characters in the word
    for (let i = 0; i < word.length; i++) {
      const letter = word[i];
      // If the character does not exist at this level in our node, 
      if (!node[letter]) {
        // then we create the node.
        node[letter] = {};
      }
      // Traverse to the next node
      node = node[letter];
    }
    // Signify that the node is the end of a word
    node.end = true;
  }
  
  /**
   * I: Regex, where . indicates any possible character
   * Can search a literal word or regex containing only letters [a-z|.]
   * returns boolean
   */
  search(word) {
    
    // Check if the current node contains the current letter
    const dfs = (node, index) => {
      // Reached end of word
      if (index === word.length) {
        // If the node is the end of a word.
        // Then the word exists
        // Otherwise it does not exist.
        return node.end;
      }
      
      const letter = word[index];
      
      // If the current character is not a period
      if (letter !== '.') {
        // Check if the node contains that character.
          if (!node[letter]) {
          // If doesn't contain character, return false
            return false;
          }
          // Otherwise, if it does then we traverse to the next node, and check the next character
          return dfs(node[letter], index + 1);
          
      // Otherwise, if the current character IS a wildcard
      } else {
        // Check all of the branches descending from the current node
        for (let branch of Object.keys(node)) {
        // Return the first branch that results in a matching word
          if (branch === 'end') {
            continue;
          }
          if (dfs(node[branch], index + 1)) {
            return true;
          }
        }
        // No branches from this node could match a word
        return false;
      }
    }
    
    return dfs(this.storage, 0) == true;
  }
}