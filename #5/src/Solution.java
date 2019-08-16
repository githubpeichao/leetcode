/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。


中心拓展法
*/
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0 || s==null) return "";
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            int len1=ex(s,i,i);
            int len2=ex(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    
    public int ex(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
