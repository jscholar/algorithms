public class Solution {
  public ListNode detectCycle(ListNode head) {
      if (head == null) return null;
      
      // Use floyds algorithm.
      ListNode fast = head;
      ListNode slow = head;
      
      do {
          fast = fast.next;
          if (fast != null) {
              fast = fast.next;
          } 
          slow = slow.next;
      } while (fast != null && fast != slow);
      
      if (fast == null) return null;
      
      ListNode node = head;
      while (slow != node) {
          slow = slow.next;
          node = node.next;
      }
      
      return node;
  }
}