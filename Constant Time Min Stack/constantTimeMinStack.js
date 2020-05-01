/**
 * Write a stack using your preferred instantiation pattern. Implement a min function
 * that returns the minimum value of all the elements in the stack in constant time.stack.

 * All of the functions in the Stack should run in constant time!
 *
 * var example = new Stack()
 *  example.push(4)
 *  example.push(3)
 *  example.min() === 3
 *  example.push(3)
 *  example.push(2)
 *  example.push(2)
 *  example.min() === 2
 */

/**
  * Stack Class
  *
  * A stack class that store comparable values (numbers and strings).
  */
var Stack = function () {
  var stack = [];

  // Stores a stack of the previous minimum values
  // The top of the stack will be the most recent min value.
  var minStack = [null];

  // add an item to the top of the stack
  this.push = function (value) {
    stack.push(value);
    // If we have a new min, add it to the stack
    if (minStack[minStack.length - 1] === null || value <= minStack[minStack.length - 1]) {
      // Add new min value to stack.
      minStack.push(value);
    }
  };

  // remove an item from the top of the stack and return it
  this.pop = function () {
    var popped = stack.pop();

    // See if we've popped the min value
    if (popped === minStack[minStack.length - 1]) {
      // Remove the previous min value
      minStack.pop();
    }

    return popped;
  };

  // return the number of items in the stack
  this.size = function () {
    return stack.length;
  };

  // return the minimum value in the stack or null if stack is empty.
  this.min = function () {
    return minStack[minStack.length - 1];
  };

};

