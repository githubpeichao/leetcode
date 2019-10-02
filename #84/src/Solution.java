/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。
示例:

输入: [2,1,5,6,2,3]
输出: 10
*/

//利用快排思想，找到最小的柱子，比较包含最小柱子的面积，最小柱子左边的面积，最小柱子右边的面积，递归查找
//但是运行时间与算法复杂度好像不是很好，解答看leetcode题解吧
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0) return 0;
        return getmax(heights,0,heights.length-1);
    }
    
    public int getmax(int[] heights,int left,int right){
        if(left>=right) return heights[left];
        int min=left;
        int minheight=heights[left];
        for(int i=left;i<=right;i++){
            if(heights[i]<minheight){
                min=i;
                minheight=heights[i];
            }
        }
        int area1=minheight*(right-left+1);
        int area2=0;
        int area3=0;
        if(left!=min) area2=getmax(heights,left,min-1);
        if(right!=min) area3=getmax(heights,min+1,right);
        return Math.max(area1,Math.max(area2,area3));
    }
}
