class Solution {
    public void nextPermutation(int[] nums) {
        int brekInd = -1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                brekInd = i;
                break;
            }
        }
        if(brekInd == -1){
            reverse(nums);
            return;
        }
        
        int max = Integer.MAX_VALUE , ind2 = -1;
        for(int i=brekInd+1;i<n;i++){
            int temp = nums[i];
            if(temp > nums[brekInd]){
                max = Math.min(max, temp);
            }
            if(max==temp) ind2=i;
        }

        int temp = nums[brekInd];
        nums[brekInd] = nums[ind2];
        nums[ind2] = temp;
        Arrays.sort(nums, brekInd+1, n);
        
    }

    public static void reverse(int[]nums){
        int i=0, j=nums.length-1;
        while(i<=j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
