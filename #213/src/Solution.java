/*
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，
这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

输入: [2,3,2]
输出: 3
解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。

两遍dp就行了，第一遍从0到len-1 第二遍从1到len，取大的值

*/
class Solution {
    public int rob(int[] nums) {
        int len=nums.length;
        if(len==0) return 0;
        if(len==1) return nums[0];
        if(len==2) return Math.max(nums[0],nums[1]);
        int[] dp1=new int[len];
        dp1[0]=0;
        dp1[1]=nums[0];
        for(int i=2;i<len;i++){
            dp1[i]=Math.max(dp1[i-1],dp1[i-2]+nums[i-1]);
        }
        int[] dp2=new int[len];
        dp2[0]=0;
        dp2[1]=nums[1];
        for(int i=2;i<len;i++){
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+nums[i]);
        }
        return Math.max(dp1[len-1],dp2[len-1]);
    }
}
