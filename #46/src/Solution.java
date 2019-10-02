import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();
        List<List<Integer>> res=new ArrayList<>();
        method(nums,0,nums.length,stack,map,res);
        return res;
    }
    
    public void method(int[] nums,int deep,int len,Stack<Integer> stack,Map<Integer,Integer> used,List<List<Integer>> res){
        if(deep==len) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for(int i=0;i<len;i++){
            if(!used.containsKey(nums[i])){
                stack.push(nums[i]);
                used.put(nums[i],1);
                method(nums,deep+1,len,stack,used,res);
                stack.pop();
                used.remove(nums[i]);
            }
        }
    }
}