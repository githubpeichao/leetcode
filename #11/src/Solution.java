
public class Solution {
	public int maxArea(int[] height) {
        int len=height.length;
        if(len==0) return 0;
        int left=0;
        int right=len-1;
        int max=0;
        while(left<right){
            int high=Math.min(height[left],height[right]);
            max=Math.max(max,(right-left)*high);
            if(height[left]>height[right]) right--;
            else left++;
        }
        return max;
    }
}
