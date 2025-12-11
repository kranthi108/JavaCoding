package GP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode curr = head;
       int count =0;
       while(curr != null && count < k) {
            curr = curr.next; count++;
       }
       if(count < k) return head;
       ListNode prev = null;
       curr = head;
       count = 0;
       while (count < k) {
           ListNode next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
           count++;
       }
       head.next = reverseKGroup(curr, k);
       return prev;
    }
}