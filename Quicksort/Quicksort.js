/**
 * Quicksort is a sorting algorithm that uses a divide and conquer strategy;
 *
 * It:
 *    Takes in an array.
 *    Picks a value in the array as a pivot.
 *    Partitions all the elements of the array into two arrays, based on
 *      if they are larger or smaller than the pivot.
 *    Recursively sorts the two halves.
 *    Combines the two arrays and the pivot into a sorted array.
 */


var quicksort = function (array) {
  if (array.length > 1) {
    // Pull a value to use as pivot
    let pivot = array[0];

    // Split into 2 arrays, for smaller than or greater than values
    let lesser = [];
    let greater = [];
    for (var i = 1; i < array.length; i++) {
      array[i] < pivot ? lesser.push(array[i]) : greater.push(array[i]);
    }

    // Sort the smaller arrays
    lesser = quicksort(lesser);
    greater = quicksort(greater);

    // Recombine the sorted arrays
    array = lesser.concat([pivot]).concat(greater);
  }

  return array;
};
