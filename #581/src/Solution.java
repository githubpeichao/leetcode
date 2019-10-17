class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length==0) return 0;
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
/*
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }
}

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int l=nums.length;
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[i]<nums[st.peek()]){
                l=Math.min(l,st.pop());
            }
            st.push(i);
        }
        st.clear();
        int r=0;
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]>nums[st.peek()]){
                r=Math.max(r,st.pop());
            }
            st.push(i);
        }
        return r-l>0?r-l+1:0;
    }
}*/
