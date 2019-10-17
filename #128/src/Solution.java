/*
给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

存入set中，num枚举set，判断有无当前数的前一个数num-1，
没有则（表示需将长度重置1，开始判断set中是否有当前值的后一个数，
         有则连续，则长度+1且num+1，
         没有则比较当前长度与longest进行替换）
有则表示连续的，已经在上一步判断过了，num继续枚举

*/
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> set=new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int longest=1;
        for(int num : set){
            if(!set.contains(num-1)){
                int curnum=num;
                int curlong=1;
                while(set.contains(curnum+1)){
                    curnum+=1;
                    curlong+=1;
                }
                longest=Math.max(curlong,longest);
            }
        }
        return longest;
    }
}
