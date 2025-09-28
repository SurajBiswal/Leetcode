class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                long sum = (long)nums[i]+ (long)nums[j];
                int s=j+1;
                int e=n-1;
                while(s<e){
                    long tempSum = sum+ (long)nums[s]+ (long)nums[e];
                    if(tempSum == target){
                        if(!ans.contains(Arrays.asList(nums[i],nums[j],nums[s],nums[e]))){
                            ans.add(Arrays.asList(nums[i],nums[j],nums[s],nums[e]));
                        }
                        s++;
                    }else if(tempSum > target){
                        e--;
                    }else{
                        s++;
                    }
                }
            }
        }
        return ans;
    }
}

