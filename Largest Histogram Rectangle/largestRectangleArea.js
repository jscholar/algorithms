const largestRectangleArea = (arr) => {
  let maxArea = 0;
  
  // Create a stack to keep track of minimum points so far, and maximum possible width of rectangle
  let stack = [];
  
  const prefixLeft = [];
  const prefixRight = [];
  
  for (let i = 0; i < arr.length; i++) {
    const curr = arr[i];
    let popped = false;
    while (stack.length && stack[stack.length - 1][0] >= curr) {
      stack.pop();
      popped = true;
    }
    // Add the current value to the stack
    stack.push([curr, i]);
    if (popped) {
      prefixLeft[i] = stack[stack.length - 1] + 1;
    } else {
      prefixLeft[i] = i;
    }
  }
  
  stack = [];
  
  for (let i = arr.length - 1; i >= 0; i--) {
    const curr = arr[i];
    let popped = false;
    while (stack.length && stack[stack.length - 1][0] >= curr) {
      stack.pop();
      popped = true;
    }
    // Add the current value to the stack
    stack.push([curr, i]);
    if (popped) {
      prefixLeft[i] = stack[stack.length - 1] - 1;
    } else {
      prefixLeft[i] = i;
    }
  }

  for (let i = 0; i < arr.length; i++) {
    maxArea = Math.max(maxArea, arr[i] * (1 + prefixRight[i] - prefixLeft[i]));
  }
  
  console.log(prefixLeft);
  console.log(prefixRight);
  
  return maxArea;
}