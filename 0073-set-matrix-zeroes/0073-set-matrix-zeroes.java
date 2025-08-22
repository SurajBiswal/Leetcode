class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix[0].length, c = matrix.length;
        boolean rowflag = false;
        boolean colFlag = false;

        for(int i=0;i<r;i++){
            if(matrix[0][i]==0) rowflag = true;
        }
        for(int i=0;i<c;i++){
            if(matrix[i][0]==0) colFlag = true;
        }

        for(int i=1;i<c;i++){
            for(int j=1;j<r;j++){
                if(matrix[i][j]==0){
                    matrix[0][j] =0;
                    matrix[i][0] =0;
                }
            }
        }
        for(int i=1;i<r;i++){
            if(matrix[0][i]==0){
                 for(int j=0;j<c;j++){
                    matrix[j][i]=0;
                 }
            }
        }
        for(int i=1;i<c;i++){
            if(matrix[i][0]==0){
                 for(int j=0;j<r;j++){
                    matrix[i][j]=0;
                 }
            }
        }
        if(rowflag==true){
            for(int i=0;i<r;i++){
                matrix[0][i]=0;
            }
        }
        if(colFlag==true){
            for(int i=0;i<c;i++){
                matrix[i][0]=0;
            }
        }
    }
}