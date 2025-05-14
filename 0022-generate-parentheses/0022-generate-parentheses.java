class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>list=new ArrayList<>();
        helper(n, list, "(", 1, 0);
        return list;
    }

    public void helper(int n, List<String>list, String s, int open, int close){
        if(close>open || open>n || close>n) return;
        if(open==n && close==n){
            list.add(s);
            return;
        }
        helper(n, list, s+"(", open+1, close);

        helper(n, list, s+")", open, close+1);
        return;
    }
}