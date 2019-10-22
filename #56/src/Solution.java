import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
	public int[][] merge(int[][] intervals) {
        List<int[]> res=new ArrayList<>();
        if(intervals.length==0 || intervals[0].length==0) return intervals;
        Arrays.sort(intervals,new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1,int[]o2) {
        		return o1[0]-o2[0];
        	}
        });
        int i=0;
        while(i<intervals.length) {
        	int left=intervals[i][0];
        	int right=intervals[i][1];
        	while(i<intervals.length-1 && right>=intervals[i+1][0]) {
        		right=Math.max(right, intervals[i+1][1]);
        		i++;
        	}
        	res.add(new int[] {left,right});
        	i++;
        }
        int[][] r=new int[res.size()][2];
        return res.toArray(r);
        //return res.toArray(new int[0][]);
    }
}
