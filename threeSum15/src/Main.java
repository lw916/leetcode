import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// 排序+双指针
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            // 需要跳过重复的组合
            while(i < j){
                int temp = nums[i] + nums[j] + nums[k];
                if(temp < 0){
                    while(i < j && nums[i] == nums[++i]);
                }else if(temp > 0){
                    while(i < j && nums[j] == nums[--j]);
                }else{
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return list;
    }
}