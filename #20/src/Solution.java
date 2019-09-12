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