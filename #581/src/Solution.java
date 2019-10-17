/*
给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

你找到的子数组应是最短的，请输出它的长度。

示例 1:

输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
说明 :

输入的数组长度范围在 [1, 10,000]。
输入的数组可能包含重复元素 ，所以升序的意思是<=。

*/

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
