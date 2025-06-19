class Solution {
    public int fib(int n) {
        return helper(n, new int[n+1]);
    }
    public int helper(int n, int []dp){
        if(n<=1)return n;
        if(dp[n] != 0) return dp[n];
        return dp[n] = fib(n-2)+fib(n-1);
    }
}