class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans = new ArrayList<>();
        ans.add(new ArrayList<>(List.of(1)));

        while(numRows > 1){
            List<Integer>list = ans.get(ans.size()-1);
            List<Integer>current = new ArrayList<>();
            current.add(1);
            if(list.size()>1){
                for(int i=0;i<list.size()-1;i++){
                    current.add(list.get(i)+list.get(i+1));
                }
            }
            current.add(1);

            ans.add(current);

            --numRows;
        }

        return ans;
    }
}