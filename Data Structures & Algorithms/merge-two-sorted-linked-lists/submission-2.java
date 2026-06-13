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
    public ListNode mergeTwoLists(ListNode i, ListNode j) {
        ListNode first= new ListNode();
        ListNode last=first;

        
        while(i!=null&&j!=null){
            // System.out.println("Last: "+last.val);
            if(i.val>j.val){
                last.next = j;
                j = j.next;
                // System.out.println("j smaller "+last.next.val);
            }else{
                last.next = i;
                i = i.next;
                // System.out.println("i smaller or equal "+last.next.val);                
            }
          last = last.next;
        }
        if(i==null&&j!=null){
            last.next=j;
            j=null;
        }else
        if(j==null&&i!=null){
            last.next=i;
            i=null;
        }
        // System.out.println("Fist Val "+ first.next.val);
        return first.next;


    }
}