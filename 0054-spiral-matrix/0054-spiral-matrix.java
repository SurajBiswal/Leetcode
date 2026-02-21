class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        ArrayList<Integer>A = new ArrayList<>();
        
        int m=mat.length  , n=mat[0].length;
        int minr=0 , minc=0;
        int maxr=m-1 , maxc=n-1;
        int count =1  ,   size=m*n;
        
        while(count<=size){
            //1st loop=> i=minr & j=minc to maxc
            for(int i=minr , j=minc ; j<=maxc && count<=size ;j++){
                A.add(mat[i][j]);
                count++;
            }
            minr++;          //increment the constant in this loop
            
        //2nd loop=> j=maxc & i=minr to maxr
            for(int i=minr,j=maxc ; i<=maxr && count<=size ; i++){
                A.add(mat[i][j]);
                count++;
            }
            maxc--;
            
            //3rd loop=> i=maxr && j=maxc to minc
            for(int i=maxr , j=maxc ; j>=minc && count<=size ; j--){
                A.add(mat[i][j]);
                count++;
            }
            maxr--;
            
    //4th loop=> i=maxr to minr && j=minc
            for(int i=maxr,j=minc ; i>=minr && count<=size; i--){
                A.add(mat[i][j]);
                count++;
            }
            minc++;
            
        }
        
        return A;
    }
}