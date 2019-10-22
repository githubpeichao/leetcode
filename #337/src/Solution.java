 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    public int rob(TreeNode root) {
        return robb(root).val;
    }
    
    public TreeNode robb(TreeNode node){
        if(node==null) {
            TreeNode newnode=new TreeNode(0);
            return robb(newnode);
        }
        if(node.left==null && node.right==null){
            node.left=new TreeNode(0);
            node.right=new TreeNode(0);
            return node;
        }
        node.left=robb(node.left);
        node.right=robb(node.right);
        node.val=Math.max(node.val+node.left.left.val+node.left.right.val+node.right.left.val+node.right.right.val,
                         node.left.val+node.right.val);
        
        return node;
    }
}