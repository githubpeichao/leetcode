/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
示例 1:
输入: 123
输出: 321

 示例 2:
输入: -123
输出: -321
*/
public class Solution {
	 public int reverse(int x) {
	     long y = 0;
	     while (x != 0) {
	         y = y * 10 + x % 10;
	         x /= 10;
	     }
	     if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE)
	         return 0;
	     return (int) y;
	  }
}
