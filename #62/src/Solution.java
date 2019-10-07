class Solution {
    public int uniquePaths_1(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++) dp[i][0]=1;
        for(int i=0;i<n;i++) dp[0][i]=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    //两种方法一样解决，下面的压缩成一个一维数组
    public int uniquePaths(int m, int n){
        int[] dp=new int[m];
        for(int i=0;i<m;i++) dp[i]=1;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[j]+=dp[j-1];
            }
        }
        return dp[m-1];
    }
}