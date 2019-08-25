/*
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

输入: [1,8,6,2,5,4,8,3,7]
输出: 49


我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。 
此外，我们会使用变量 maxareamaxarea 来持续存储到目前为止所获得的最大面积。 
在每一步中，我们会找出指针所指向的两条线段形成的区域，更新 maxareamaxarea，并将指向较短线段的指针向较长线段那端移动一步。

*/
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
