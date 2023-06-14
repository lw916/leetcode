import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        if( nums == null ){
            return;
        }else{
            int i = 0;
            int j = 0;
            while(i != nums.length){
                if(nums[i] != 0){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j++] = temp;
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{0,1,0,3,12};
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}