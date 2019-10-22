/*
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
示例 1:

输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。

用map存储超时了
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public List<Integer> findAnagrams(String s, String p) {
        char[] s_arr = s.toCharArray();
        char[] p_arr = p.toCharArray();
        List<Integer> list = new ArrayList<>();

        char[] p_letter = new char[26];
        for(int i = 0; i < p_arr.length;i++){
            p_letter[p_arr[i] - 'a']++;
        }


        for(int i = 0;i < s_arr.length - p_arr.length + 1;i++){
            char[] temp = new char[26];
            //放入hash
            if(p_letter[s_arr[i] - 'a'] == 0) continue;
            for(int j = i; j < i + p_arr.length;j++){
                temp[s_arr[j] - 'a']++;
            }
            //匹配hash
            boolean ok = true;
            for(int j = 0;j < p_arr.length;j++){
                if(temp[p_arr[j] - 'a'] == 0){
                    ok = false;
                    break;
                }else{
                    temp[p_arr[j] - 'a']--;
                }
            }
            //ok 加入list
            if(ok){
                list.add(i);
            }
        }
        return list;

    }

    /*用map存储超时了
    public List<Integer> findAnagrams(String s, String p) {
        int length=p.length();
        List<Integer> res=new ArrayList<>();
        
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<length;i++){
            if(map.containsKey(p.charAt(i))) map.put(p.charAt(i),map.get(p.charAt(i))+1);
            else map.put(p.charAt(i),1);
        }
        for(char c:map.keySet()) {
        	System.out.println(c+":"+map.get(c));
        }
        for(int i=0;i<s.length()-length+1;i++){
            Map<Character,Integer> tmp=new HashMap<>();
            for(int j=i;j<i+length;j++){
                char c=s.charAt(j);
                if(!map.containsKey(c)) continue;
                if(tmp.containsKey(s.charAt(j))) tmp.put(s.charAt(j),tmp.get(s.charAt(j))+1);
                else tmp.put(s.charAt(j),1);
            }
            System.out.println("tmp");
            for(char c:tmp.keySet()) {
            	System.out.println(c+":"+tmp.get(c));
            }
            if(compare(map,tmp)) res.add(i);
        }
        return res;
    }
    
    public boolean compare(Map<Character,Integer> map1,Map<Character,Integer> map2){
        boolean flag=true;
        for(char c:map1.keySet()){
            if(!map2.containsKey(c) || map1.get(c)!=map2.get(c)) flag=false;
        }
        return flag;
    }
    */
}
