
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int eachLen=numRows*2-2;
        StringBuilder re = new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j+i<s.length();j=j+eachLen){
                re.append(s.charAt(j+i));
                if(i !=0 && i !=numRows-1 && j+eachLen-i<s.length())
                    re.append(s.charAt(j+eachLen-i));
            }
        }
        return re.toString();
    }
}
