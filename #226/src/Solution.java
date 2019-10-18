/*
翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1

*/
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
