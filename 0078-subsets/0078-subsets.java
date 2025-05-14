class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer>arr = new ArrayList<>();
        ArrayList<Integer>nums2 = new ArrayList<>();

        for(int x:nums){
            nums2.add(x);
        }

        return helper(arr, nums2);
    }

    public static List<List<Integer>> helper(ArrayList<Integer>arr, ArrayList<Integer>nums){
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        if(nums.size()==0){
            list.add(new ArrayList<>(arr));
            return list;
        }
        ArrayList<Integer>nums2 = new ArrayList<>(nums);
        arr.add(nums2.get(0));
        nums2.remove(0);
        list.addAll(helper(arr, nums2));
        arr.remove(arr.size()-1);
        list.addAll(helper(arr, nums2));
        return list;
    }
}