class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length==0) return false;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;
        int target=sum/2;
        
        boolean[][] res=new boolean[nums.length][target+1];
        for(int i=1;i<target+1;i++){
            if(nums[0]==i) res[0][i]=true;
        }
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<target+1;j++){
                res[i][j]=res[i-1][j];
                if(j>=nums[i])
                    res[i][j]=res[i-1][j] || res[i-1][j-nums[i]];
            }
        }
        
        return res[nums.length-1][target];
    }
}