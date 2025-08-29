class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer>set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int maxCnt=0;

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int cnt=1;
            int j=1;
            if(!set.contains(num-j)){
                while(set.contains(num+j)){
                    cnt++;
                    set.remove(num+j);
                    j++;
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }
}