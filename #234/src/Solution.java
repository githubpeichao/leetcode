/*
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true

从中间拆分成两个链表，遍历两个链表判断val是否相等
*/
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 
public class Solution {
    public boolean isPalindrome(ListNode head) {
        int length=0;
        ListNode node=head;
        while(node!=null){
            node=node.next;
            length++;
        }
        
        node=head;
        ListNode pre=null;
        ListNode next;
        for(int i=0;i<length/2;i++){
            next=node.next;
            node.next=pre;
            pre=node;
            node=next;
        }
        
        if(length%2==1)  node=node.next;
        boolean flag=true;
        while(node!=null && pre!=null){
            if(node.val!=pre.val){
                flag=false;
                break;
            } 
            node=node.next;
            pre=pre.next;
        }
        return flag;
    }
}
