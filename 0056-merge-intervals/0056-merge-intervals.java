class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        int start=intervals[0][0], last=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] <= last){
                if(intervals[i][1]>last)last = intervals[i][1];
            }else{
                ans.add(new ArrayList<>(Arrays.asList(start, last)));
                start = intervals[i][0];
                last = intervals[i][1];
            }
        }
        ans.add(new ArrayList<>(Arrays.asList(start, last)));
        int[][]ans2 = ans.stream()
        .map(row->row.stream().mapToInt(x->x.intValue()).toArray())
        .toArray(int[][]::new);


        return ans2;
    }
}