import java.util.ArrayList;
import java.util.List;

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

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        reserve(root, result);
        return result;
    }

    void reserve(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        reserve(root.left, list);
        reserve(root.right, list);
    }

}