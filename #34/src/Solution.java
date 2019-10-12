class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=leftSearch(nums,target);
        ans[1]=rightSearch(nums,target);
        return ans;
    }
    
    public int leftSearch(int[] nums,int target){
        if (nums.length==0) return -1;
        int left=0;
        int right=nums.length;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                right=mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid;
            }
        }
        if(left==nums.length) return -1;
        return nums[left]==target? left:-1;
    }
    
    public int rightSearch(int[] nums,int target){
        if(nums.length==0) return -1;
        int left=0;
        int right=nums.length;
        while (left<right) {
            int mid=(left+right) / 2;
            if(nums[mid]==target) {
                left=mid+1; // зЂвт
            }else if(nums[mid]<target) {
                left=mid+1;
            }else if(nums[mid]>target) {
                right=mid;
            }
        }
        if (left==0) return -1;
        return nums[left-1]==target?(left-1):-1;
    }
}