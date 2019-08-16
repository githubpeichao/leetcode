/*
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

*/
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int eachLen=numRows*2-2;  //每组有这么多个数
        StringBuilder re = new StringBuilder();
        for(int i=0;i<numRows;i++){ //每一行每一行进行添加
            for(int j=0;j+i<s.length();j=j+eachLen){ // 每一行的下标都是j+eachLen
                re.append(s.charAt(j+i));  //第j组的第i个数
                if(i !=0 && i !=numRows-1 && j+eachLen-i<s.length()) //每组的第一行和最后一行只有一个数，再判断是否越界，没有则要再添加一个
                    re.append(s.charAt(j+eachLen-i));  //两个数的下标和为eachLen
            }
        }
        return re.toString();
    }
}
