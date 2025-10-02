class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character>set = new HashSet<>();
        int l=0, r=0;
        int n = s.length();
        int max = 0;
        while(r<n){
            char temp = s.charAt(r);
            while(set.contains(temp)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(temp);
            r++;
            max = Math.max(max, r-l);
        }
        return max;
    }
}