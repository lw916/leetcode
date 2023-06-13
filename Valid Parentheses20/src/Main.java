import java.util.HashMap;
import java.util.Objects;

class Solution {
    public boolean isValid(String s) {
        int length = s.length() / 2;
        for(int i = 0; i < length; i++){
            s = s.replace("()","").replace("{}","").replace("[]","");
        }

        return s.length() == 0;
    }

    public static void main(String[] args) {
        Solution S = new Solution();
        System.out.println(S.isValid("{[]}"));
    }

}