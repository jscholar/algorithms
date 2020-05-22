const canReach = (arr, start) => {
  // Initialize a data structure (Set) to store information about the nodes we've already traversed.
  const seen = new Set();
  
  const dfs = (index) => {
    const step = arr[index];
    
    // If the element we're at is 0
    if (step === 0) {
      // then it's possible to reach a 0 from the starting index
      return true;
    }
    
    // Check if this node is one that has already been seen
    if (seen.has(index)) {
      // Return
      return false;
    }
    
    // Add this index to our set of already seen nodes
    seen.add(index);
    // Traverse to the left if it possible
    if (index - step >= 0 && dfs(index - step)) {
      // If a solution is found, then it's possible and return true right away
      return true;
    } 
    
    // Traverse to the right if possible
    if (index + step < arr.length && dfs(index + step)) {
      // If found, return true.
      return true;
    } 
    
    // return false, no path found to a 0
    return false;
  }
  
  return dfs(start);
}
