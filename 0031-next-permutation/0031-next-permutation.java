class Solution {
    public void nextPermutation(int[] nums) {
        int pivotInd = findPivot(nums);
        if(pivotInd < 0){
            Arrays.sort(nums);
            return;
        }
        findNextGreterAndSwap(nums, pivotInd);
        Arrays.sort(nums, pivotInd+1, nums.length);
    }
    public int findPivot(int[] nums){
        int i=nums.length-2;
        while(i>=0){
            if(nums[i]<nums[i+1]) return i;
            i--;
        }
        return i;
    }

    public void findNextGreterAndSwap(int[] nums, int pivot){
        int n = nums.length;
        for(int i=n-1; i>pivot; i--){
            if(nums[pivot]<nums[i]){
                swap(nums, pivot, i);
                break;
            }
        }
    }

    public void swap(int[]nums, int pivot, int i){
        int temp = nums[pivot];
        nums[pivot] = nums[i];
        nums[i] = temp;
    }
}