class Solution {
    public int majorityElement(int[] nums) {
        int max = nums[0];
        int cnt = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]==max){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt<0){
                cnt=1;
                max = nums[i];
            }
        }

        return max;
    }
}