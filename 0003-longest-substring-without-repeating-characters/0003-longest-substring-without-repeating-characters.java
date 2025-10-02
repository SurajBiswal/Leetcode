class Solution {
    public int lengthOfLongestSubstring(String s) {
        // if(s.equals("")) return 0;
        // if(s.trim().isEmpty()) return 1;
        int[]arr = new int[128];
        int l=0, r=0;
        int n = s.length();
        int max = 0;
        while(r<n){
            char temp = s.charAt(r);
            arr[temp]+=1;
            while(arr[temp] > 1){
                arr[s.charAt(l)]-=1;
                l++;
            }
            r++;
            max = Math.max(max, r-l);
        }
        return max;
    }
}