import java.math.BigInteger;

class Solution {
    public int mySqrt(int x) {
        int res = 0;
        if(x == 0 || x == 1){
            res = x;
        }else if(x == 2){
            res = x / 2;
        }else{
            int mid = x / 2;
            BigInteger sqrtMid = BigInteger.valueOf((long) mid * mid);
            if(sqrtMid.compareTo(BigInteger.valueOf(x)) <= 0){
                for(int i = mid; i < x; i++){
                    if(i * i > x){
                        res =  i - 1;
                        break;
                    }
                }
            }else{
                for(int i = 0; i <= mid; i++){
                    BigInteger temp = BigInteger.valueOf((long) i * i);
                    if( temp.compareTo(BigInteger.valueOf(x)) > 0){
                        res =  i - 1;
                        break;
                    }
                }
            }
        }
        return res;
    }

    // 二分查找法：
    public int mySqrt2(int x){
        int left = 1, right = x;
        while(left < right){
            int mid = left + (right - left) / 2;
            if( mid < x / mid ){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left <= x / left ? left : left - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt2(8));
        System.out.println(s.mySqrt2(2147395599));
        System.out.println(s.mySqrt(2147395600));
    }
}