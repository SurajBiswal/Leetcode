class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n<=1)return n;
        int[]arr = new int[128];
        int start=0, end=0;
        int len=0;
        boolean flag =true;

            while(start<n && s.charAt(start)==' '){
                ++start;
            }
            while(end<n && s.charAt(end)==' '){
                ++end;
            }

        while(end<n){
            flag = false;
            char newChar = s.charAt(end);
            char oldChar = s.charAt(start);

            while(arr[newChar-' ']>=1){
                arr[oldChar-' ']-=1;
                ++start;
                oldChar = s.charAt(start);
            }
            len = Math.max(len, end-start+1);
            arr[newChar-' '] = 1;
            ++end;
        }
        return (flag==false)?len:1;
    }
}