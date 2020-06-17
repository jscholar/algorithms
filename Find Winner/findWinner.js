const findWinner = (candidates) => {
  const map = new Map();

  let winner = candidates[0];

  candidates.forEach((name) => {
    if(!map.has(name)) {
      map.set(name, 0);
    } 
    map.set(name, map.get(name) + 1);
    if (map.get(name) >= map.get(winner)) {
      winner = name;
    }
  });

  return winner;
}

module.exports = findWinner;
