/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode curr = head;
        ListNode prev = null;
        if (n == 1 && head.next == null) {
            return null;
        }
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            length++;
        }
        curr = prev;

        int count = 0;
        prev = null;
        if (n > length)
            return null;
        if (n == 1) {
            curr = curr.next;
        }
        ListNode start = curr;
        while (n > 1 && curr != null) {
            count++;
            if (count == n) {
                ListNode next = curr.next;
                prev.next = next;

                break;
            }
            prev = curr;
            curr = curr.next;
        }
        curr = start;
        prev = null;
        System.out.println(curr.val);

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // System.out.println(curr.val);

        return prev;
    }
}
