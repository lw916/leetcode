class Solution {
    // 超时
    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            max = Math.max(max, temp);
            for(int j = i+1; j < nums.length; j++){
                temp += nums[j];
                max = Math.max(max,temp);
            }
        }
        return max;
    }

    public int maxSubArray(int[] nums){
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{5,4,-1,7,8};
        System.out.println(s.maxSubArray(nums));
    }
}