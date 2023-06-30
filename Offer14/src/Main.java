// 数学写法
class Solution {
    public int cuttingRope(int n) {
        if(n == 1 || n == 2) return 1;
        if(n == 3) return 2;
        int sum = 1;
        while(n > 4){
            sum *= 3;
            n -= 3;
        }
        return sum * n;
    }
}

// 动态规划
class Solution2{
    public int cuttingRope(int n){
        int[] dp = new int[n + 2];
        for(int i = 2; i <= n; i++){
            int curMax = 0;
            for(int j = 1; j < i; j++){
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i-j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}