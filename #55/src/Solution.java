/*class Solution {
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
