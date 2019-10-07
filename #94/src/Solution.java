/*
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]

*/
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        if(root!=null){
            TreeNode node=root;
            while(node!=null || !st.isEmpty()){
                if(node!=null){
                    st.push(node);
                    node=node.left;
                }else{
                    node=st.pop();
                    res.add(node.val);
                    node=node.right;
                }
            }
        }
        return res;
    }
}
