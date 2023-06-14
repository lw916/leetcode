// 全词匹配，没有再慢慢减到直到没有为止。
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        int i = 1;
        while( i < strs.length ){
            while(strs[i].indexOf(str) != 0){
                str = str.substring(0, str.length() - 1);
            }
            i++;
        }
        return str;
    }
}