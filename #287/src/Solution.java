/*
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

示例 1:

输入: [1,3,4,2,2]
输出: 2
示例 2:

输入: [3,1,3,4,2]
输出: 3

1、用一个set去存遍历过的数字，出现一样的则跳出循环，返回此值
2、排序，比较前后两个数字是否相等
3、假设有这样一个样例：[1,2,3,4,5,6,7,8,9,5]。如果我们按照上面的循环下去就会得到这样一个路径: 1 2 3 4 5 [6 7 8 9] [6 7 8 9] [6 7 8 9] 
   . . .这样就有了一个环，也就是6 7 8 9。point会一直在环中循环的前进。变成链表找环

*/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


class Solution {
	
	public int findDuplicate(int[] nums) {
		Set<Integer> set=new HashSet<Integer>();
		int index=0;
		for(int i=0;i<nums.length;i++) {
			if(set.contains(nums[i])) {
				index=i;
				break;
			}
			else set.add(nums[i]);
		}
		return nums[index];
	}
	
	public int findDuplicate_2(int[] nums) {
		Arrays.sort(nums);
		for(int i=1;i<nums.length;i++) {
			if(nums[i]==nums[i-1]) return nums[i];
		}
		return -1;
	}
	
	public int findDuplicate_3(int[] nums) {
		int slow=0;
		int fast=0;
		while(true) {
			fast=nums[nums[fast]];
			slow=nums[slow];
			if(fast==slow) break;
		}
		int res=0;
		while(true) {
			res=nums[res];
			slow=nums[slow];
			if(slow==res) break;
		}
		return res;
	}
}
