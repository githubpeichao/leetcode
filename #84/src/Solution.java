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