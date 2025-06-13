class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int e = 0;
        int s = 1;
        for(int pile : piles){
            e = Math.max(pile, e);
        }
        
        int k=e;
        while(s<=e){
            int mid = s+(e-s)/2;
            long count=0;
            for(int pile : piles){
                count+= (pile+mid-1)/mid;
            }
            if(count<=h){
                k = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return k;
    }
}