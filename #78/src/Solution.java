import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for(Integer n:nums){
            int size=res.size();
            for(int i=0;i<size;i++){
                List<Integer> list=new ArrayList<Integer>(res.get(i));
                list.add(n);
                res.add(list);
            }
        }
        return res;
    }
}