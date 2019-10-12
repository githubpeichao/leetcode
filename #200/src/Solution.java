class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        int row=grid.length-1;
        int col=grid[0].length-1;
        int count=0;
        for(int i=0;i<=row;i++){
            for(int j=0;j<=col;j++){
                if(grid[i][j]=='1'){
                    find(grid,i,j,row,col);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void find(char[][] grid,int i,int j,int row,int col){
        if(i<0 || i>row || j<0 || j>col || grid[i][j]=='0') return;
        grid[i][j]='0';
        find(grid,i+1,j,row,col);
        find(grid,i-1,j,row,col);
        find(grid,i,j+1,row,col);
        find(grid,i,j-1,row,col);
    }
}