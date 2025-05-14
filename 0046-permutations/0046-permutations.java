class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        helper(nums, 0, ans);
        return ans;
    }
    public void helper(int[]nums, int i, List<List<Integer>>ans){
        if(i==nums.length){
            List<Integer>list = new ArrayList<>();
            for(int num:nums){
                list.add(num);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int j=i;j< nums.length;j++){
            swap(nums, i, j);
            helper(nums, i+1, ans);
            swap(nums, i, j);
        }
    }
    public void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
} 
 