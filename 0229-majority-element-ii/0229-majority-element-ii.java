class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer>ans = new ArrayList<>();
        int c1= nums[0], f1=1;
        int i=1;
        while(i<n && nums[i]==c1){
            f1++;
            i++;
        }
        if(i==n) return Arrays.asList(c1);

        int c2 = nums[i], f2=1;
        i++;
        while(i<n){
            int c = nums[i];
            if(c==c1){
                f1++;
            }else if(c==c2){
                f2++;
            }else{
                if(f1>0 && f2>0){
                    f1--;
                    f2--;
                }else if(f1==0){
                     c1 = c;
                     f1 = 1;
                }else if(f2==0){
                    c2 = c;
                    f2 = 1;
                }
            }
            i++;
        }

        i=0; 
        f1=0; 
        f2=0;
        while(i<n){
            if(nums[i]==c1)f1++;
            else if(nums[i]==c2)f2++;
            i++;
        }
        if(f1>n/3)ans.add(c1);
        if(f2>n/3)ans.add(c2);

        return ans;
    }
}


