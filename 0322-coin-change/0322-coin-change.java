class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][]dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        Arrays.sort(coins);
        int ans = helper(0, coins, amount, dp);
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
    public int helper(int ind, int[] coins, int amount, int[][]dp){
        if(amount==0) return 0;
        if(ind==coins.length || coins[ind]> amount) return Integer.MAX_VALUE;
        if(dp[ind][amount]!=-1)return dp[ind][amount];

        int pickSame =Integer.MAX_VALUE;
        int path1 = helper(ind, coins, amount-coins[ind], dp);
        if(path1 != Integer.MAX_VALUE) pickSame=1+path1;

        int pick = Integer.MAX_VALUE;
        int path2 = helper(ind+1, coins, amount-coins[ind], dp);
        if(path2 != Integer.MAX_VALUE) pick=1+path2;

        int notPick = helper(ind+1, coins, amount, dp);

        return dp[ind][amount]= Math.min(pickSame, Math.min(pick, notPick));
    }
}