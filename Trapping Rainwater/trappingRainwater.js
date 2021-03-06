/*
  Given n non-negative integers representing an elevation map where the width of each bar is 1,
  compute how much water it is able to trap after raining.
*/

/**
 * @param { number[] } land Integers representing an elevation map
 * @returns { number } Integer representing grid area of trappable water
 */
const trap = (land) => {
  let trapped = 0;

  // Represent potential trappable water from most recent maximum height
  let potWater = [];

  for (let i = 0; i < land.length; i++) {
    const height = land[i];

    // Update maximum height
    if (height > potWater.length) {
      potWater = potWater.concat(new Array(height - potWater.length).fill(0));
    }
    
    // Trap potential water below height
    for (let h = 0; h < height; h++) {
      trapped += potWater[h];
      potWater[h] = 0;
    }

    // Add potential water up to maximum height
    for (let h = height; h < potWater.length; h++) {
      potWater[h] += 1;
    }
  }

  return trapped;
}


/**
 * @param { number[] } land Integers representing an elevation map
 * @returns { number } Integer representing grid area of trappable water
 */
const trapTwoPointers = (land) => {
  let trapped = 0;


  let left = 0;
  let right = land.length - 1;

  let leftMax = 0;
  let rightMax = 0;

  while (left < right) {
    if (land[left] < land[right]) {
      if (land[left] > leftMax) {
        leftMax = land[left];
      } else {
        trapped += leftMax - land[left];
      }
      left += 1;
    } else {
      if (land[right] > rightMax) {
        rightMax = land[right];
      } else {
        trapped += rightMax - land[right];
      }
      right -= 1;
    }
  }

  return trapped;
}
