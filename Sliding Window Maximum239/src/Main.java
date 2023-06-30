import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if(length == 0) return nums;
        Deque<Integer> queue = new LinkedList<>();
        int[] arr = new int[length - k + 1];
        int arr_index = 0;

        for(int i = 0; i < k; i++){
            while(!queue.isEmpty() && queue.peekLast() < nums[i]){
                queue.removeLast();
            }
            queue.offerLast(nums[i]);
        }
        arr[arr_index++] = queue.peekFirst();
        for(int j = k; j < length; j++){
            if(nums[ j - k ] == queue.peekFirst()){
                queue.removeFirst();
            }
            while(!queue.isEmpty() && queue.peekLast() < nums[j]){
                queue.removeLast();
            }
            queue.offerLast(nums[j]);
            arr[arr_index++] = queue.peekFirst();
        }
        return arr;
    }
}