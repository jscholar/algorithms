var mergeSort = function (array) {
  if (array.length > 1) {
    // Split such that the left is already sorted
    let mid = 1;
    while (mid < array.length && array[mid] >= array[mid - 1]) {
      mid++;
    }
    let left = array.slice(0, mid);
    let right = array.slice(mid, array.length);

    right = mergeSort(right);

    array = mergeSortedArrays(left, right);
  }
  return array;
};

// Merge two sorted arrays into a sorted array.
var mergeSortedArrays = function (left, right) {
  let sorted = [];

  let i = 0;
  let j = 0;

  while (i < left.length && j < right.length) {
    if (left[i] <= right[j]) {
      // Preserve stability of original array for equal comparisons
      sorted.push(left[i]);
      i++;
    } else {
      sorted.push(right[j]);
      j++;
    }
  }

  if (i < left.length) {
    sorted = sorted.concat(left.slice(i));
  } else {
    sorted = sorted.concat(right.slice(j));
  }

  return sorted;
}
