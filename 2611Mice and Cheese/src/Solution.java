import java.util.Arrays;

// 贪心+排序
class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
       int ans = 0;
       int length = reward1.length;
       for(int i=0; i < length; i++){
           ans += reward2[i];
           reward1[i] = reward1[i] - reward2[i];
       }
       Arrays.sort(reward1);
       for(int i = length - 1; i >= length - k; i--){
           ans+= reward1[i];
       }
       return ans;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        int[] list1 = new int[]{1,1,3,4};
        int[] list2 = new int[]{4,4,1,1};
        System.out.println(S.miceAndCheese(list1, list2, 2));
    }
}