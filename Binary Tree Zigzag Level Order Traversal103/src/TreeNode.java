import java.util.ArrayList;
import java.util.Collections;
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

// 层次遍历
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        reserve(root, 0, map);
        if(root == null) return ans;
        else{
            boolean isDouble = false;
           for(Integer key : map.keySet()){
               if(isDouble){
                   List<Integer> temp = map.get(key);
                   Collections.reverse(temp);
               }
               ans.add(map.get(key));
               isDouble = !isDouble;

           }
        }
        return ans;
    }

    void reserve(TreeNode tree, int layer, HashMap<Integer,ArrayList<Integer>> map){
        if(tree == null) return;
        else layer++;
        reserve(tree.left, layer, map);
        reserve(tree.right, layer, map);
        ArrayList<Integer> list = new ArrayList<>();
        if(map.get(layer) != null ){
            list = map.get(layer);
        }
        list.add(tree.val);
        map.put(layer, list);
    }
}
