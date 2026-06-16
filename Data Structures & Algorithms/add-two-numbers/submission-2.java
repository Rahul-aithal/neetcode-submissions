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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sol = null;
        ListNode start = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry ;
            System.out.println(sum);
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            }else{
                carry=0;
            }
            ListNode s = new ListNode(sum);
            if (sol != null) {
                sol.next = s;

            } else {
                start = s;
            }
            sol = s;
            l1 = l1.next;
            l2 = l2.next;
        }
 while (l1 != null ) {
            int sum = l1.val + carry ;
            // System.out.println(sum);
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
           }else{
                carry=0;
            }
            ListNode s = new ListNode(sum);
            if (sol != null) {
                sol.next = s;

            } else {
                start = s;
            }
            sol = s;
            l1 = l1.next;
 
        }
        while (l2 != null ) {
            int sum = l2.val + carry ;
            // System.out.println(sum);
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            }else{
                carry=0;
            }
            ListNode s = new ListNode(sum);
            if (sol != null) {
                sol.next = s;

            } else {
                start = s;
            }
            sol = s;
     
            l2 = l2.next;
        }



        if (carry > 0) {
            ListNode s = new ListNode(carry);

            if (sol != null) {
                sol.next = s;

            } else {
                start = s;
            }
        }

        return start;
    }
}
