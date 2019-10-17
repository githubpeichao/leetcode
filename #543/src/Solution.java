class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {
    private int ans;
    
    public int diameterOfBinaryTree(TreeNode root) {
        ans=1;
        deep(root);
        return ans-1;
    }
    
    public int deep(TreeNode node){
        if(node==null) return 0;
        int l=deep(node.left);
        int r=deep(node.right);
        ans=Math.max(ans,l+r+1);
        return Math.max(l,r)+1;
    }
}