class NumMatrix {
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int ROWS=matrix.length;
        int COLS=matrix[0].length;

        prefix=new int[ROWS+1][COLS+1];

        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){

                int total=matrix[r][c];
                int top=prefix[r][c+1];
                int left=prefix[r+1][c];
                int overlap=prefix[r][c];

                prefix[r+1][c+1]=total+top+left-overlap;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total=prefix[row2+1][col2+1];
        int topToSubtract=prefix[row1][col2+1];
        int leftToSubtract=prefix[row2+1][col1];
        int overlap=prefix[row1][col1];

        return total - topToSubtract - leftToSubtract + overlap;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */