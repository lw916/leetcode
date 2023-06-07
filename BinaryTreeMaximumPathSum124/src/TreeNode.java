
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

// 后序遍历
class Solution {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        traverse(root);
        return res;
    }

    int traverse(TreeNode root){
        if (root == null) return 0;
        int left = Math.max( 0, traverse(root.left));
        int right = Math.max( 0, traverse(root.right));
        res = Math.max( res, left + right + root.val );
        return Math.max(left , right) + root.val;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode treeLeft = new TreeNode(2);
        TreeNode treeRight = new TreeNode(3);
        TreeNode treeRoot = new TreeNode(1, treeLeft, treeRight);
        System.out.println(s.maxPathSum(treeRoot));
    }
}