/*
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].


动态规划 https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/
这是一道以 0-1 背包问题为背景的算法练习题，我们把这个题目翻译一下：

给定一个只包含正整数的非空数组。是否可以从这个数组中挑选出一些正整数，每个数只能用一次，使得这些数的和等于整个数组元素的和的一半。

0-1 背包问题也是最基础的背包问题，它的特点是：待挑选的物品有且仅有一个，可以选择也可以不选择。下面我们定义状态，不妨就用问题的问法定义状态试试看。

dp[i][j]：表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和等于 j。

根据我们学习的 0-1 背包问题的状态转移推导过程，新来一个数，例如是 nums[i]，根据这个数可能选择也可能不被选择：

如果不选择 nums[i]，在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，那么 dp[i][j] = true；
如果选择 nums[i]，在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i] ，我既然这样写出来了，你就应该知道，这里讨论的前提条件是 nums[i] <= j。
以上二者成立一条都行。于是得到状态转移方程是：

dp[i][j] = dp[i - 1][j] or dp[i - 1][j - nums[i]], (nums[i] <= j)
于是按照 0-1 背包问题的模板，我们不难写出以下代码。

*/
class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length==0) return false;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;
        int target=sum/2; //计算总和的二分之一
        
        boolean[][] res=new boolean[nums.length][target+1]; //动态boolean数组
        for(int i=1;i<target+1;i++){
            if(nums[0]==i) res[0][i]=true;   //找到那个等于nums[0]的位置，为true
        }
        
        for(int i=1;i<nums.length;i++){  //res[0]表示在[0,0]区间里是否有元素等于nums[0]，动态规划从1开始
            for(int j=0;j<target+1;j++){
                res[i][j]=res[i-1][j];
                if(j>=nums[i])
                    res[i][j]=res[i-1][j] || res[i-1][j-nums[i]];
            }
        }
        
        return res[nums.length-1][target];
    }
}
