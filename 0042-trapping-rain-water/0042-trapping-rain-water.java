class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lm = height[0];
        int rm = height[n-1];
        int l = 0, r = n-1;
        int water=0;
        while(l<r){
            if(height[l]<=height[r]){
                if(height[l]<lm && height[l]<rm){
                    water+= Math.min(lm,rm)-height[l];
                }else if(height[l]>lm){
                    lm = height[l];
                }
                l++;
                lm = (height[l]>lm) ? height[l] : lm;
            }else{
                if(height[r]<lm && height[r]<rm){
                    water+= Math.min(lm,rm)-height[r];
                }else if(height[r]>rm){
                    rm = height[r];
                }
                r--;
                rm = (height[r]>rm) ? height[r] : rm;
            }
        }
        return water;
    }
}