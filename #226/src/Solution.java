class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode temp1=invertTree(root.left);
        root.left=invertTree(root.right);
        root.right=temp1;
        return root;
    }
}