import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque();
        dfs(nums, ans, path, 0);
        return ans;
    }

    public void dfs(int[] nums, List<List<Integer>> ans, Deque<Integer> path, int start){
        ans.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++){
            path.addLast(nums[i]);
            dfs(nums, ans, path, i+1);
            path.removeLast();
        }
    }

}