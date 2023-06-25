import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrace(nums,ans,path,visited);
        return ans;
    }

    public void backtrace(int[] nums, List<List<Integer>> ans, List<Integer> path, int[] visited){
        if(path.size() == nums.length){
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 1){
                continue;
            }
            visited[i] = 1;
            path.add(nums[i]);
            backtrace(nums, ans, path,visited);
            visited[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}