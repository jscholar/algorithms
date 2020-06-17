const assert = require('assert');
const findWinner = require('./findWinner');

describe('Find Winner', () => {
  it('should return the candidate with the most votes', () => {
    assert.equal(findWinner(['A', 'B', 'A']), 'A');
    assert.equal(findWinner(['A', 'B', 'A', 'C', 'C', 'C']), 'C');
    assert.equal(findWinner(['B']), 'B');
  });
  it('should, upon a tie, return the candidate who got the final tally first', () => {
    assert.equal(findWinner(['A', 'A', 'B', 'C', 'C']), 'C');
    assert.equal(findWinner(['A', 'A', 'B', 'B']), 'B');
    assert.equal(findWinner(['A', 'B', 'C', 'C', 'B', 'A']), 'A');
  });
});
