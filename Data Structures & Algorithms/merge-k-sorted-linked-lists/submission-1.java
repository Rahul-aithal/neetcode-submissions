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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode();

        if (lists.length == 0)
            return dummyHead.next;
        ListNode head = dummyHead.next;
        head = lists[0];
        ListNode first = head;
        while (head.next != null) {
            head = head.next;
        }
        System.out.println(head.val);
        if (lists.length == 1)
            return dummyHead.next;

        for (int i = 1; i < lists.length; i++) {
            ListNode a = lists[i];
            System.out.println("a "+a.val);
            while (a != null) {
                if (head == null) {
                    head.next = a;
                    head = head.next;
                    first = dummyHead.next;
                    a = a.next;

                    continue;
                }

                if (first.val >= a.val) {
                    ListNode acp = new ListNode(a.val);
                    dummyHead.next = acp;
                    acp.next = first;
                    first = dummyHead.next;
                } else if (head.val <= a.val) {
                    head.next = a;
                    head = head.next;
                } else {
                    ListNode start = first;
                    while (start.next != null && start.next.val < a.val) {
                        start = start.next;
                    }
                    ListNode acp = new ListNode(a.val);

                    if (start.next != null) {
                        ListNode next = start.next;
                        start.next = acp;
                        acp.next = next;
                    } else {
                        start.next = acp;
                    }
                }
                a = a.next;
            }
        }
        return first;
    }
}
