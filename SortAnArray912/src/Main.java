import java.util.Arrays;
import java.util.Random;

class Solution {
    public int[] sortArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] newNums = new int[max - min + 1];
        for (int num : nums) {
            newNums[num - min]++;
        }
        int j = nums.length - 1;
        for (int i = max - min; i >= 0;i--) {
            int n = newNums[i];
            while (n > 0) {
                nums[j] = i + min;
                n--;
                j--;
            }
        }
        return nums;

    }

    // 快排
    public int[] sortArray1(int[] nums){
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    //入口
    void quickSort(int[] nums, int left, int right){
        if(left < right){
            int pos = quickSortRandom(nums, left, right);
            quickSort(nums, left, pos - 1 );
            quickSort(nums, pos + 1, right);
        }
    }

    // 任意选择一个数字作为排序的对比数字
    int quickSortRandom(int[] nums, int left, int right){
        int pointer = new Random().nextInt(right - left + 1) + left;
        swap(nums, pointer, right);
        return sorting(nums, left, right);
    }

    // 排序主函数
    int sorting(int[] nums, int left, int right){
        int i = left;
        int numToCompare = nums[right];
        for(int j = left; j <= right - 1; j++){
            if(nums[j] <= numToCompare){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    // 交换数组中内容的位置
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{4,7,6,8,2,3,1,5};
        System.out.println(Arrays.toString(s.sortArray1(nums)));
    }

}