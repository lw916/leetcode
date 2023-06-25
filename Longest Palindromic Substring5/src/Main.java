class Solution {
    // 中心扩展法
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = boolFromMiddle(s,i,i);
            int len2 = boolFromMiddle(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > right - left){
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        return s.substring(left,right + 1);
    }

    public int boolFromMiddle(String s, int left, int right){
        int Left = left;
        int Right = right;
        while(Left >= 0 && Right < s.length() && s.charAt(Left) == s.charAt(Right)){
            Left--;
            Right++;
        }
        return Right - Left - 1;
    }
}