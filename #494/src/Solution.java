class Solution {
    int res=0;
    
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length==0) return 0;
        find(nums,S,0);
        return res;
    }
    public void find(int[] nums,int s,int index){
        if(index==nums.length) {
            if(s==0)  res++;
            return;
        }
        int num=nums[index];
        index++;
        find(nums,s-num,index);
        find(nums,s+num,index);
    }
}