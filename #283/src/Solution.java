/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]

每一个非0数前面有多少个0，就index前移多少，再后面补上0
*/
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
