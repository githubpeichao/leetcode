import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if(nums.length==0) return res;
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=nums[nums[i]-1]) swap(nums,i,nums[i]-1);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1) res.add(i+1);
        }
        return res;
    }
        
    public void swap(int[] nums,int index1,int index2){
        if (index1 == index2) return;
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index1] ^ nums[index2];
        nums[index1] = nums[index1] ^ nums[index2];
    }
}