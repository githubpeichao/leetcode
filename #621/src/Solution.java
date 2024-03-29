/*
给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务
都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。

然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的最短时间。

示例 1：

输入: tasks = ["A","A","A","B","B","B"], n = 2
输出: 8
执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.

*/
import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length==0) return tasks.length;
        int[] count=new int[26];
        for(int i=0;i<tasks.length;i++){
            count[tasks[i]-'A']++;
        }
        Arrays.sort(count);
        int maxcount=count[25];
        int res=(maxcount-1)*(n+1)+1;
        int i=24;
        while(i>=0 && count[i]==maxcount){
            res++;    //排在最后面的+1
            i--;
        }
        return Math.max(res,tasks.length); //如果前面排完了还有空槽，说明res是最佳的。如果空槽没了还有任务未排进去，说明按照原数组长度即可
    }
}
