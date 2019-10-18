class Solution {
    public void moveZeroes(int[] nums) {
        int zeronum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) zeronum++;
            else nums[i-zeronum]=nums[i];
        }
        for(int i=nums.length-zeronum;i<nums.length;i++){
            nums[i]=0;
        }
    }
}