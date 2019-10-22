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
            res++;
            i--;
        }
        return Math.max(res,tasks.length); //如果前面排完了还有空槽，说明res是最佳的。如果空槽没了还有任务未排进去，说明按照原数组长度即可
    }
}