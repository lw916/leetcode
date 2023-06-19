import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        if(root == null){
            return result;
        }else{
            reserve(root, 0, map);
            for(Integer key: map.keySet()){
                result.add(map.get(key));
            }
        }
        return result;
    }

    void reserve(TreeNode tree, int layer, HashMap<Integer,ArrayList<Integer>> map){
        if(tree == null){
            return;
        }else{
            layer++;
        }
        reserve(tree.left, layer, map);
        reserve(tree.right, layer, map);
        ArrayList<Integer> list = new ArrayList<>();
        if(map.get(layer) != null){
            list = map.get(layer);
        }
        list.add(tree.val);
        map.put(layer, list);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        Solution s = new Solution();
        s.levelOrder(tree);
    }

}