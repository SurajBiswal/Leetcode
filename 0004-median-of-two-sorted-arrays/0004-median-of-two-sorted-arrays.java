class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int size = n1+n2;
        int m1=size/2;
        int m2 = size%2 == 0 ? (size/2)-1 : 0;
        double mid1=0,mid2=0;
        int i=0, j=0, k=0;
        while(i<n1 && j<n2){
            if(nums1[i]<=nums2[j]){
                if(k==m1) mid1=nums1[i];
                if(size%2 == 0 && k==m2) mid2=nums1[i];
                i++;
                k++;
            }else{
                if(k==m1) mid1=nums2[j];
                if(size%2 == 0 && k==m2) mid2=nums2[j];
                j++;
                k++;
            }
        }
        while(i<n1){
            if(k==m1) mid1=nums1[i];
            if(size%2 == 0 && k==m2) mid2=nums1[i];
            i++;
            k++;
        }
        while(j<n2){
            if(k==m1) mid1=nums2[j];
            if(size%2 == 0 && k==m2) mid2=nums2[j];
            j++;
            k++;
        }
        return size%2==0 ? ((double)mid1+(double)mid2)/2 : mid1;
    }
}
