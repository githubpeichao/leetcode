/*
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
你可以假设网格的四个边均被水包围。

示例 1:

输入:
11110
11010
11000
00000

输出: 1
示例 2:

输入:
11000
11000
00100
00011

输出: 3

状态遍历过的则改为'0'
*/
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
