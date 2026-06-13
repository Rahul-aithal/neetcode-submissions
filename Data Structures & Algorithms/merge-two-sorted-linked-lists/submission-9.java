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
        if(i==null) return j;
        if(j==null) return i;
        ListNode last= new ListNode();
        ListNode first=last;

        
        while(i!=null&&j!=null){
            if(i.val>j.val){
                last.next = j;
                j = j.next;
            }else{
                last.next = i;
                i = i.next;
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
       return first.next;


    }
}