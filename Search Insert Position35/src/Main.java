class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while( left <= right ){
            int mid = (right + left) / 2;
            if(target < nums[mid]){
                right = mid-1;
            }else if(target > nums[mid]){
                left = mid+1;
            }else{
                return mid;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        Solution S = new Solution();
        System.out.println(S.searchInsert(nums,7));
    }
}