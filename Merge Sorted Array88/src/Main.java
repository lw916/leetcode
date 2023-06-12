import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for( int i = 0; i != n; ++i){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}

// 指针方法
class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while(p1 < m || p2 < n){
            if(p1 == m){
                cur = nums2[p2++]; // nums1的数字已经放进去了
            } else if(p2 == n){
                cur = nums1[p1++];// nums2的数字已经放进去了
            } else if( nums1[p1] > nums2[p2]){
                cur = nums2[p2++];
            } else {
                cur = nums1[p1++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for( int i = 0; i != m+n; i++ ){
            nums1[i] = sorted[i];
        }
    }
}