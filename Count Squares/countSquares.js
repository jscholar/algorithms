const countSquares = (mat) => {
  let count = 0;
  // Iterate through each element
  for (let r = 0; r < mat.length; r++) {
    for (let c = 0; c < mat[r].length; c++) {
      // Finds the maximum size square this top left corner could make
      let max = Math.min(mat[r].length - c, mat.length - r);
      for (let i = r; i - r < max && i < mat.length; i++) {
        for (let j = c; j - c < max && j < mat[i].length; j++) {
          // Iterate through subsequent rows up to max, until a 0 is reached
          if (mat[i][j] === 0) {
            max = j - c;
            break;
          }
          if (i - r === j - c) {
            count++;
          }
        }
      }
    }
  }
  
  return count;
}