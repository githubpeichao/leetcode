import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> set=new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int longest=1;
        for(int num : set){
            if(!set.contains(num-1)){
                int curnum=num;
                int curlong=1;
                while(set.contains(curnum+1)){
                    curnum+=1;
                    curlong+=1;
                }
                
                longest=Math.max(curlong,longest);
            }
        }
        return longest;
    }
}