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
    public boolean hasCycle(ListNode head) {
              if(head==null||head.next==null) return false;
        ListNode i = head.next,j=head.next.next;
        
        while(j!=null&&j.next!=null){
            if(i==j) return true;
            i=i.next;
            j=j.next.next;
        }
        return false;
    }
}
