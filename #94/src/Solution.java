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
