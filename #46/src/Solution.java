/*
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
//回溯法解决，用map记录这个数是否用过，用stack保存顺序，每次回溯都要重置状态，将nums[i]从map中删除
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
