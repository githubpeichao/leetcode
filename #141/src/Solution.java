/**
给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

 

示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。


 * Definition for singly-linked list.*/
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 //不多bb，直接冲
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
