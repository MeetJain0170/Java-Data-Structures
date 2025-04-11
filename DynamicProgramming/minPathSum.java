public class minPathSum {
    public static int min(int[][]grid){
        int m=grid.length;
        int n=grid[0].length;
        for(int i=1; i<m; i++){
            grid[i][0]=grid[i-1][0];
        }
        for(int j=1; j<m; j++){
            grid[0][j]=grid[0][j-1];
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                grid[i][j]=Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }return grid[m-1][n-1];
    }
}
