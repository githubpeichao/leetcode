/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/

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
