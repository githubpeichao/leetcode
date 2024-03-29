/*
编写一个程序，找到两个单链表相交的起始节点。
*/
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode nodea=headA;
        ListNode nodeb=headB;
        while(nodea!=nodeb){
            nodea=nodea==null? headB:nodea.next;
            nodeb=nodeb==null? headA:nodeb.next;
        }
        return nodea;
    }
}
