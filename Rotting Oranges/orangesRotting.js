const orangesRotting = (grid) => {
  const queue = [];
  let minutes = 0, fresh = 0;
  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (grid[i][j] === 2) {
        queue.push([i,j]);
      } else if (grid[i][j] === 1) {
        fresh++;
      }
    }
  }

  let dir = [[0,1],[0,-1],[1,0],[-1,0]];

  while (queue.length > 0 && fresh > 0) {
    minutes++;
    let n = queue.length;
    for (let m = 0; m < n; m++) {
      const [i, j] = queue.shift();
      for (let [x, y] of dir) {
        if (grid[i + x] && grid[i + x][j + y] === 1) {
          fresh--;
          grid[i + x][j + y] = 2;
          queue.push([i + x, j + y]);
        }
      }
    }
  }

  return fresh === 0 ? minutes : -1;
}