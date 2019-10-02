/**
 * Definition for singly-linked list.*/
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        if(head.next==null) return false;
        if(head.next.next==null) return false;
        ListNode fast=head.next.next;
        ListNode slow=head.next;
        while(fast!=slow){
            if(fast.next!=null && fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }else{
                return false;
            }
        }
        return true;
    }
}