class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr->arr[0]));
        List<int[]>list=new ArrayList<>();
        int s=intervals[0][0], e=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(e>=intervals[i][0]){
                e= Math.max(e, intervals[i][1]);
                continue;
            }
            list.add(new int[]{s,e});
            s=intervals[i][0];
            e=intervals[i][1];
        }
        list.add(new int[]{s,e});
        int[][]ans = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}