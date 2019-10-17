/*
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.

动态规划
下面一种是递归去找所有的情况
*/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for(int i=0;i<n+1;i++){
            dp[i]=i;
            for(int j=1;i-j*j>=0;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
/*
class Solution{
	public List<List<Integer>> numSquares(int n) {
		List<List<Integer>> res=new ArrayList<>();
		back(n,res,new ArrayList<>());
		return res;
	}
	public void back(int n,List<List<Integer>> res,ArrayList<Integer> temp) {
		if(n<0) return;
		if(n==0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for(int j=1;j<n;j++) {
			temp.add(j);
			back(n-j*j,res,temp);
			temp.remove(temp.size()-1);
		}
	}
}*/
