class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>st=new Stack<>();
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            int nextgret = -1;
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }                    
            if(!st.isEmpty()){
                nextgret = st.peek();
            }
            map.put(nums2[i], nextgret);
            st.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}
