/*
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。

示例 :
给定二叉树

          1
         / \
        2   3
       / \     
      4   5    
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

*/
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
