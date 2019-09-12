/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

*/

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack();
        boolean flag=true;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(st.isEmpty() ||c==40 ||c==91 ||c==123){
                st.push(c);
            }else if(c==41){
                if(st.peek()==40) st.pop();
                else {
                    flag=false;
                    break;
                }
            }else if(c==93){
                if(st.peek()==91)st.pop();
                else {
                    flag=false;
                    break;
                }
            }else if(c==125){
                if(st.peek()==123)st.pop();
                else {
                    flag=false;
                    break;
                }
            }
        }
        if(!st.isEmpty()) flag=false;
        return flag;
    }
}
