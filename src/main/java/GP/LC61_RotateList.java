package GP;

public class LC61_RotateList {
    public static void main(String[] args) {
        // Create the linked list
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        // Rotate the list
        ListNode result = rotateList(head, 3);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }

    public static ListNode rotateList(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head; // No rotation needed
        }

        // Step 1: Calculate the length of the list
        ListNode temp = head;
        int n = 1; // Initialize length as 1 because we're already at the head
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }

        // Step 2: Normalize `k` to avoid unnecessary rotations
        k = k % n;
        if (k == 0) {
            return head; // No rotation needed
        }

        // Step 3: Find the new tail (n - k)th node
        int stepsToNewTail = n - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Step 4: Perform the rotation
        ListNode newHead = newTail.next; // The new head is the next node
        newTail.next = null;             // Break the list
        temp.next = head;                // Reconnect the last node to the original head

        return newHead;
    }
}

