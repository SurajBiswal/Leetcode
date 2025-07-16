class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int size = nums.length;
        int[]nums1 = new int[size];
        Stack<Integer>st = new Stack<>();
        for(int i=(size*2)-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i % size]){
                st.pop();
            }
            nums1[i % size] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i  % size]);
        }
        return nums1;
    }
}


