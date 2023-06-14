import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        int i = 0;
        while( i < nums.length){
            set.add(nums[i]);
            i++;
        }
        System.out.println(set);
        int[] nums_temp = new int[nums.length];
        int k = 0;
        for(Integer j : set){
            nums_temp[k] = j;
            k++;
        }
        nums = nums_temp;
        System.out.println(Arrays.toString(nums));
        return set.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        s.removeDuplicates(nums);
    }
}