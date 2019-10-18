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