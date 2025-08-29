class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int freq =1;
        for(int i=1;i<n;i++){
            if(nums[i]==ans){
                freq++;
            }else{
                freq--;
            }
            if(freq==0){
                ans = nums[i];
                freq = 1;
            }
        }
        return ans;
    }
    
}
