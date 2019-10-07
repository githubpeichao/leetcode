/*
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]

-----------层序遍历，加个now和next记录这一层的节点数量
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null) return res;
        queue.offer(root);
        TreeNode node=null;
        int now=1;
        int next=0;
        while(!queue.isEmpty()){
            node=queue.poll();
            list.add(node.val);
            now--;
            if(node.left!=null){
                queue.offer(node.left);
                next++;
            }
            if(node.right!=null){
                queue.offer(node.right);
                next++;
            }
            if(now==0){
                res.add(new ArrayList(list));
                list.clear();
                now=next;
                next=0;
            }
        }
        return res;
    }
}
