/**
 * Given an array of distinct integers, return all possible perumutations
 * @param {Array<Number>} arr 
 * @returns An array containing all possible permutations
 */
const permutations = (arr) => {
  const perms = [];
  const cur = [];
  const dfs = () => {
    if (!arr.length) {
      perms.push(cur.slice());
      return;
    }
    let n = arr.length;
    for (let i = 0; i < n; i++) {
      const int = arr[i];
      cur.push(int);
      arr.splice(i, 1);
      dfs();
      cur.pop();
      arr.splice(i, 0, int);
    }
  }
  
  dfs();
  return perms;
}