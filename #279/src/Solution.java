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