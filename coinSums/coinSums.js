/*

In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

1p piece
2p piece
5p piece
10p piece
20p piece
50p piece
£1 (100p)
£2 (200p)

It is possible to make £2 in the following way:

1 * £1 + 1 * 50p + 2 * 20p + 1 * 5p + 1 * 2p + 3 * 1p
How many different ways can £2 be made using any number of coins?

example usage of `makeChange`:

// aka, there's only one way to make 1p. that's with a single 1p piece
makeChange(1) === 1
// aka, there's only two ways to make 2p. that's with two, 1p pieces or with a single 2p piece
makeChange(2) === 2
*/

const coins = [ // In English pence
  200,
  100,
  50,
  20,
  10,
  5,
  2,
  1
]

// Using a stack
var makeChange = function (total) {
  /* 
      This algorithm requires that coins is sorted
      since it tries the largest coins first
  */
  coins = coins.sort((a, b) => b - a);

  var waysForChange = 0;

  let lastCoin = 0;
  let change = [];

  while (lastCoin < coins.length || change.length !== 0) {
    if (total === 0) {
      waysForChange++;
    }
    if (total <= 0 || lastCoin === coins.length) {
      // Pop the last coin
      let coin = change.pop();
      total += coins[coin];

      // Try the next smaller coin
      lastCoin = coin + 1;
    } else {
      // Try the coin
      change.push(lastCoin);
      total -= coins[lastCoin];
    }
  }

  return waysForChange;
};
