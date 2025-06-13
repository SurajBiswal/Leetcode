class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[][]dp = new Integer[n][n+1];
        return fun(nums, 0, -1, dp);
    }

    public static int fun(int[] nums, int curr, int prev, Integer[][]dp){
        if(curr==nums.length) return 0;
        if(dp[curr][prev+1]!=null)return dp[curr][prev+1];

        int pick = 0;
        if(prev==-1 || nums[curr]>nums[prev]){
        pick = 1+fun(nums, curr+1, curr, dp);
        }

        int nonPick = fun(nums, curr+1, prev, dp);

        return dp[curr][prev+1] = Math.max(pick, nonPick);
    }
}