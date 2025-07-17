class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivotIndex = -1;

        // Step 1: Find the rightmost index where nums[i] < nums[i + 1]
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivotIndex = i;
                break;
            }
        }

        if (pivotIndex == -1) {
            reverse(nums, 0, n - 1); // Entire array is non-increasing, reverse it
            return;
        }

        // Step 2: Find the rightmost element greater than nums[pivotIndex]
        for (int i = n - 1; i > pivotIndex; i--) {
            if (nums[i] > nums[pivotIndex]) {
                swap(nums, i, pivotIndex);
                break;
            }
        }

        // Step 3: Reverse the suffix starting at pivotIndex + 1
        reverse(nums, pivotIndex + 1, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
