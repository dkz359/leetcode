////珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
////
//// 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，
//然后
////这一小时内不会再吃更多的香蕉。
////
//// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
////
//// 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
////
////
////
////
////
////
//// 示例 1：
////
////
////输入：piles = [3,6,7,11], h = 8
////输出：4
////
////
//// 示例 2：
////
////
////输入：piles = [30,11,23,4,20], h = 5
////输出：30
////
////
//// 示例 3：
////
////
////输入：piles = [30,11,23,4,20], h = 6
////输出：23
////
////
////
////
//// 提示：
////
////
//// 1 <= piles.length <= 10⁴
//// piles.length <= h <= 10⁹
//// 1 <= piles[i] <= 10⁹
////
//// Related Topics 数组 二分查找 👍 369 👎 0
//


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 爱吃香蕉的珂珂
 * 二分法的应用之一：求最值
 * @author dukz
 * @date 2022-06-07 19:01:26
 */
public class P875_KokoEatingBananas{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P875_KokoEatingBananas().new Solution();
	 }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
		int low =1;
		int high = Arrays.stream(piles).max().getAsInt();
		int res = high;
		while (low < high){
			int speed = (high-low)/2+low;
			int time = getTime(piles, speed);
			if(time<=h){
				res=speed;
				high = speed;
			}else{
				low=speed+1;
			}
		}
		return res;
    }

	public int getTime(int[] piles, int speed){
		int time = 0;
		for (int pile : piles) {
			int curTime = (pile + speed -1) / speed;
			time += curTime;
		}
		return time;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
