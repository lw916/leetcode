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

    void traverse(TreeNode root, List<String> array, List<Integer> path){
        path.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder string = new StringBuilder();
            for(int i = 0; i < path.size() - 1; i++){
                string.append(path.get(i)).append("->");
            }
            string.append(path.get(path.size() - 1));
            array.add(string.toString());
            return;
        }
        if(root.left != null){
            traverse(root.left, array, path);
            path.remove(path.size() - 1);
        }
        if(root.right != null){
            traverse(root.right, array, path);
            path.remove(path.size() - 1);
        }

    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root == null){
            return result;
        }
        traverse(root, result, path);
        return result;
    }

}