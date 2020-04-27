/**
 * A Fibonacci sequence is a list of numbers that begins with 0 and 1, and each
 * subsequent number is the sum of the previous two.
 *
 * example usage:
 * nthFibonacci(2); // => 1
 * nthFibonacci(3); // => 2
 * nthFibonacci(4); // => 3
 * etc...
 *
 */

var nthFibonacci = function (n) {
  if (n === 0) return 0;
  if (n === 1) return 1;

  return nthFibonacci(n - 1) + nthFibonacci(n - 2);
};
