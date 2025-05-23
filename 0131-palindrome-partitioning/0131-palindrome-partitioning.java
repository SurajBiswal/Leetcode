class Solution {
    public List<List<String>> partition(String s) {
        List<String>list = new ArrayList<>();
		List<List<String>>ans = new ArrayList<>();
		helper(0, s, list, ans);
        return ans;
    }
    public static void helper(int startInd, String s, List<String>list, List<List<String>>ans){
        if(startInd == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=startInd; i<s.length(); ++i){
            if(isPalindrome(s, startInd, i)){
                list.add(s.substring(startInd, i+1));
                helper(i+1, s, list, ans);
                list.remove(list.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }
}