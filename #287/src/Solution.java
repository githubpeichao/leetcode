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
