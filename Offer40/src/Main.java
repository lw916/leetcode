class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        sort(arr);
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = arr[i];
        }
        return ans;
    }

    // 冒泡排序
    public void sort(int[] arr){
        int length = arr.length;
        for(int i = 0; i < length; i++){
            for(int j = length - 1; j >= 1; j-- ){
                if(arr[j] < arr[j - 1]){
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j-1] = temp;
                }
            }
        }
    }
}