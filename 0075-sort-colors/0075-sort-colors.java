class Solution {
    public void sortColors(int[] nums) {
        int s = 0;
        int m = 0;
        int e = nums.length-1;
        while(m<=e){
            if(nums[m]==2){
                swap(nums,m,e);
                e--;
            }else if(nums[m]==0){
                swap(nums, m, s);
                s++;
                if(s>=m)m++;
            }else{
                m++;
            }
        }

    }

    public void swap(int[]nums,  int a, int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
    }
}