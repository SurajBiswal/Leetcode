class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix[0].length, c = matrix.length;
        int[]row = new int[r];
        int[]col= new int[c];
        for(int i=0;i<c;i++){
            for(int j=0;j<r;j++){
                if(matrix[i][j]==0){
                    row[j]=-1;
                    col[i] =-1;
                }
            }
        }
        for(int i=0;i<r;i++){
            if(row[i]==-1){
                 for(int j=0;j<c;j++){
                    matrix[j][i]=0;
                 }
            }
        }
        for(int i=0;i<c;i++){
            if(col[i]==-1){
                 for(int j=0;j<r;j++){
                    matrix[i][j]=0;
                 }
            }
        }
    }
}