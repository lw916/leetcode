import java.util.HashMap;

// 滑动窗口法
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> temp = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for( int i = 0; i < s.length(); i++ ){
            if(temp.containsKey(s.charAt(i))){
                left = Math.max(left, temp.get(s.charAt(i)) + 1);
            }
            temp.put(s.charAt(i),i);
            max = Math.max(max, i - left+1);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        System.out.println(S.lengthOfLongestSubstring("abcabcbb"));
    }
}