class Solution {
    public int countSubstrings(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            res+=find(s,i,i);
            res+=find(s,i,i+1);
        }
        return res;
    }
    
    public int find(String s,int left,int right){
        int count=0;
        while(left>=0 && right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
}