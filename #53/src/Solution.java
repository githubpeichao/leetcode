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