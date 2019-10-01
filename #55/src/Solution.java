/*给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
*/
/*   回溯暴力破解---超时了
class Solution {
    public boolean canJump(int[] nums) {
        return can(nums,0);
    }
    public boolean can(int[] nums,int i){
        if(i==nums.length-1) return true;
        int n=Math.min(i+nums[i],nums.length-1);
        for(int j=i+1;j<=n;j++){
            if(can(nums,j)) return true;
        }
        return false;
    }
}*/
//动态规划-------Boolean类型的dp数组----题解有贪心算法优化---翻翻看
class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp=new boolean[nums.length];
        dp[0]=true;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && nums[j]+j>=i) {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }
}
