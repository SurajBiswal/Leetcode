class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[]rightmax = new int[n];
        rightmax[n-1] = height[n-1];
        for(int i=n-2;i>=1;i--){
            rightmax[i] = (height[i]>rightmax[i+1]) ? height[i] : rightmax[i+1];
        }
        int leftmax = height[0];
        int water=0;

        for(int i=1;i<n;i++){
            int curr = height[i];
            if((curr < leftmax) && (curr < rightmax[i])){
                water+=Math.min(leftmax, rightmax[i]) - curr;
            }
            if(curr>leftmax) leftmax = curr;
        }
        return water;
    }
}