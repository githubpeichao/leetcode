/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]

看题解吧
https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/
*/
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
                left=mid+1; // ×˘Ňâ
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
