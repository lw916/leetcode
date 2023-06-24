class Solution {
    public int reverse(int x) {
        int res = 0;
        if(x == 0) return res;
        if( x > 0 ){
            while(x > 0){
                int temp = x % 10;
                res += temp;
                res = res * 10;
                x = x / 10;
            }
        }else{
            x = Math.abs(x);
            while(x > 0){
                int temp = x % 10;
                res += temp;
                res = res * 10;
                x = x / 10;
            }
            res = -res;
        }
        return res / 10;
    }

    // 上面方法遇到超int范围会出问题
    public int reverse1(int x) {
        long n = 0;
        while (x!=0){
            n = n*10+x%10;
            x=x/10;
        }
        return (int)n==n? (int)n:0;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(1534236469));
    }
}