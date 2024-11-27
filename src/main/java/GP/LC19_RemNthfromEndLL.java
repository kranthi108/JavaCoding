package GP;


import java.util.List;


public class LC19_RemNthfromEndLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        ListNode result = removeNthFromEnd(head, 3);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && n>0) {
            fast = fast.next;
            n--;
        }
        if(fast==null)
            return head.next;
        while(fast.next!=null){
            slow=slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
