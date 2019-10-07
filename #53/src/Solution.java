/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

*/
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int sum=0;
        int ans=nums[0];
        for(int num:nums){
            if(sum>0) sum=num+sum;
            else sum=num;
            ans=Math.max(sum,ans);
        }
        return ans;
    }
}
