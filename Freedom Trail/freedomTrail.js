/*

  Given a string 'ring', which represents the characters on ring,
  and given a string 'key', find the minimum number of steps in order to spell
  all characters in 'key' using 'ring'.
  
  
  Rotating the ring by 1 character is a step.
  Submitting character is also a step.
  
  Length of 'ring' and 'key'. 1 < l < 100
  
  All lowercase letters, duplicates may exist in 'ring' and 'key'
  
  Guaranteed that all chars in 'key' are in 'ring'
  
  First character of ring is aligned at 12.

  

  Example:
  
  Input:
  
  Ring = 'goddingaaae'
  Key  = 'gde'
  
  [
    g: [0, 6]
    d: [2, 3, 8, 15]
    o: [1]
    i: [4]
    n: [5]
  ]
  
  
  Expected output = 4

*/

const findRotateSteps = (ring, key) => {
  
  // Create a data structure to store the locations of characters in a hashtable
  const positions = {};
  
  for (let i = 0; i < ring.length; i++) {
    const char = ring[i];
    if (positions[char] === undefined) {
      positions[char] = [];
    }
    positions[char].push(i);
  }
  
  let bestSoFar = Infinity;
  
  const dfs = (position, charIndex, stepsSoFar = 0) => {
    if (stepsSoFar >= bestSoFar) {
      return Infinity;
    }
    
    if (charIndex >= key.length) {
      bestSoFar = Math.min(bestSoFar, stepsSoFar);
      return 0;
    }
    
    // If current position is already on desired character
    if (ring[position] === key[charIndex]) {
      // Continue to next character
      return 1 + dfs(position, charIndex + 1, stepsSoFar + 1);
    }
    
    // Find the two closest desired characters,
    let leftPosition = position;
    let leftSteps = 0;
    while (ring[leftPosition] !== key[charIndex]) {
      leftSteps++;
      leftPosition--;
      if (leftPosition === -1) {
        leftPosition = ring.length - 1;
      }
    }
    
    let rightPosition = position;
    let rightSteps = 0;
    while (ring[rightPosition] !== key[charIndex]) {
      rightPosition++;
      rightSteps++;
      if (rightPosition === ring.length) {
        rightPosition = 0;
      }
    }
    
    // dfs to those positions and count their steps required
    // Return the min-steps between left or right
    const left = leftSteps + 1 + dfs(leftPosition, charIndex + 1, leftSteps + stepsSoFar + 1);
    const right =  rightSteps + 1 + dfs(rightPosition, charIndex + 1, rightSteps + stepsSoFar + 1);
    
    return Math.min(left, right);
  }
  
  return dfs(0, 0, 0);
}
