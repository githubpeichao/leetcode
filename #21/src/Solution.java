/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode l3=null;
        ListNode head=null;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val) {
                if(head == null){  
                    head = l1;  
                    l3 = l1;
                }else{
                    l3.next = l1;  
                    l3 = l3.next;
                }
                l1=l1.next;
            }
            else {
               if(head == null){  
                    head = l2;  
                    l3 = l2;
                }else{
                    l3.next = l2;  
                    l3 = l3.next;
                }
                l2 = l2.next;
            }
        }
        if(l1!=null) l3.next=l1;
        if(l2!=null) l3.next=l2;
        return head;
    }
}
