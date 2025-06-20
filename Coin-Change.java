class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)return 0;
        int n = coins.length;
        int[][]dp = new int[n+1][amount+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        int ans =  helper(coins, n-1, amount, dp);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
    public static int helper(int[] coins,int i,int amt, int[][]dp){
        if(amt==0)return 0;
        if(i<0) return Integer.MAX_VALUE;
        if(dp[i][amt] != -1) return dp[i][amt];
        int pick = Integer.MAX_VALUE;
        if(amt>=coins[i]){
            int res = helper(coins, i, amt-coins[i], dp);
            if(res != Integer.MAX_VALUE) pick = res+1;
        }
        int not_pick = helper(coins, i-1, amt, dp);
        return dp[i][amt] = Math.min(pick, not_pick);
    }
}