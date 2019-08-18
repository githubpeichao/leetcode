
public class Solution {
	public int rob(int[] nums) {
        if(nums.length==0) return 0;
        int preNum=0;
        int curNum=0;
        for(int x:nums){
            int temp=curNum;
            curNum=Math.max(preNum+x,curNum);
            preNum=temp;
        }
        return curNum;
    }
}
