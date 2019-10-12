import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {	
    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        back(candidates,target,res,new ArrayList<Integer>(),0);
        return res;
    }

    public  void back(int[] candidates,int target,List<List<Integer>> res,ArrayList<Integer> temp,int i) {
    	if(target<0) return;
    	if(target==0) {
    		res.add(new ArrayList<>(temp));
    		return;
    	}
    	for(int j=i;j<candidates.length;j++) {
    		if (target < candidates[j]) break;
    		temp.add(candidates[j]);
    		back(candidates,target-candidates[j],res,temp,j);
    		temp.remove(temp.size() - 1);
    	}
    }
}
