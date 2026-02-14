class Solution {
    public void nextPermutation(int[] nums) {
        int pivotInd = findPivot(nums);
        if(pivotInd < 0){
            reverse(nums, 0, nums.length-1);
            return;
        }
        findNextGreterAndSwap(nums, pivotInd);
        reverse(nums, pivotInd+1, nums.length-1);
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

    public void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j){
        while(i<=j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}