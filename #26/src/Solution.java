class Solution {
    public int removeDuplicates(int[] nums) {
        int count=1;
        for(int i=1;i<nums.length;i++){
            while(i<nums.length && nums[i]==nums[i-1]){
                i++;
            }
            if(i>=nums.length) {
            	nums[count]=nums[i-1];
            }
            else{
            	nums[count]=nums[i];
            	count++;
            }
            
        }
        return count;
    }
}