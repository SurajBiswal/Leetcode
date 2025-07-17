class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        disInt(0,nums,ans);
        return ans;
    }

    public static void disInt(int ind , int[]nums, List<List<Integer>>ans){
        if(ind == nums.length){
             List<Integer>list = new ArrayList<>();
             for(int i=0;i<nums.length;i++){
                 list.add(nums[i]);
             }
             ans.add(list);
        }

        for(int i=ind;i<nums.length;i++){
            swap(i, ind, nums);
            disInt(ind+1, nums, ans);
            swap(i, ind, nums);
        }
    }
    public static void swap(int i, int ind, int[]nums){
        int temp = nums[i];
        nums[i] = nums[ind];
        nums[ind] = temp;
    }
}