class Solution {
    public char kthCharacter(long k, int[] operations) {
        long len =1;
        int limitOfOperation=0;
        for(int i=0;i<operations.length;i++){
            if(len>=k)break;
            len*=2;
            ++limitOfOperation;
        }

        int increment = 0;

        for(int i=limitOfOperation-1;i>=0;i--){
            if(k > len/2){
                k-=len/2;
                if(operations[i]==1) ++increment; 
            }
            len/=2;
        }
        return (char)('a'+(increment % 26));
    }
}