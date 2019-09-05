class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=new StringBuilder();
        if(strs.length==0) return sb.toString();
        int index=0;
        int minlen=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()<minlen) minlen=strs[i].length();
        }
        for(int i=0;i<minlen;i++){
            char c=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(c!=strs[j].charAt(i)) return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
