class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[] count = new int[nums.length];
        if(nums.length == 0) return 0;
        else if(nums.length == 1) return 1;
        else{
            for(int i = 1; i < nums.length; i++){
                if(nums[i] < nums[i-1]) count[i] = -1;
                else if(nums[i] > nums[i-1]) count[i] = 1;
                else count[i] = count[i-1];
            }
            int result = 1;
            for(int i = 1; i < nums.length; i++){
                if(count[i] != count[i-1]){
                    result++;
                }
            }
            return result;
        }
    }
}