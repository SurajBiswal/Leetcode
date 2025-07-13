class Solution {
    public int integerBreak(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return calc(n, dp);
    }
    public int calc(int n, int[]dp){
        if(n==1) return 1;
        if(dp[n] != -1) return dp[n];
        for(int i=1;i<n;i++){
            dp[n] = Math.max((Math.max(n-i, calc(n-i, dp))*i),dp[n]);
        }
        return dp[n];
    }
}