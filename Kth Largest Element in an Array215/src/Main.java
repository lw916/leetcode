import java.util.Arrays;
import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 使用快排
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    void quickSort(int[] nums, int left, int right){
        if(left < right){
            int pos = randomQuickSort(nums, left, right);
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }

    int randomQuickSort(int[] nums, int left, int right){
        int pointer = new Random().nextInt(right - left + 1) + left;
        swap(nums, pointer, right);
        return sorting(nums, left, right);
    }

    int sorting(int[] nums, int left, int right){
        int numberToCompare = nums[right];
        int j = left;
        for(int i = left; i <= right - 1; i++){
            if(nums[i] <= numberToCompare){
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, j, right);
        return j;
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int find(int[] nums, int k){
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = nums.length - 1; j > 0; j--){
                if(nums[j] < nums[j-1]){
                    swap(nums, j, j-1);
                }
            }
        }
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,5,6,4,7,3,1,2};
        Solution s = new Solution();
        System.out.println(s.find(nums, 1));
    }
}