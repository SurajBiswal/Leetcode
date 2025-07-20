class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int i=0,j=coins.length-1;
        int [][]dp = new int[coins.length][amount+1];
        for(int []row:dp)Arrays.fill(row, -1);
        int ans = calcCombo(coins, amount, 0, dp);
        if(ans < Integer.MAX_VALUE) return ans;
        return -1;
    }
    public int calcCombo(int[]coins, int amt, int ind, int[][]dp){

        if(amt==0) return 0;
        if(ind >= coins.length || amt < 0) return Integer.MAX_VALUE;

        if(dp[ind][amt] != -1) return dp[ind][amt];

        int pick = calcCombo(coins, amt-coins[ind], ind, dp);
        if(pick < Integer.MAX_VALUE) pick+=1;

        int notPick = calcCombo(coins, amt, ind+1, dp);

        return dp[ind][amt] = Math.min(pick, notPick);
    }
}

