/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
  let reversed = null;
  let node = head;
  while (node !== null) {
      const temp = node.next;
      node.next = reversed;
      reversed = node;
      node = temp;
  }
  
  return reversed;
};