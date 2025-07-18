class Solution {
    public int maxProfit(int[] prices) {
        int s=prices[0];
        int l=Integer.MIN_VALUE;
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            int curr = prices[i];
            if(curr<s){
                s=curr;
                l=Integer.MIN_VALUE;
            }else if(curr>l){
                l = curr;
                maxProfit = Math.max(maxProfit, l-s);
            }
        }
        return maxProfit;
    }
}
