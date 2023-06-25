import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        Deque<Integer> path = new ArrayDeque();
        dfs(nums, set, path, 0);
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    public void dfs(int[] nums, Set<List<Integer>> set, Deque<Integer> path, int start){
        set.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++){
            path.addLast(nums[i]);
            dfs(nums, set, path, i+1);
            path.removeLast();
        }
    }

    List<List<Integer>>  res  = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }
    public void backtrack(int[] nums, int cur, List<Integer> path){
        if(cur>=nums.length){
            res.add(new ArrayList<>(path));
        }else{
            path.add(nums[cur]);
            int next = cur+1;//1, 4, 4, 4, 4
            backtrack(nums,next, path);
            path.remove(path.size()-1);
            while(next<nums.length&&nums[next]==nums[cur]) next++;
            backtrack(nums,next,path);
        }
    }
}