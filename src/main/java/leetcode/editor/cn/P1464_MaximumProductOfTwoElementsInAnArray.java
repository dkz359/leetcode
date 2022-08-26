//给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
//
// 请你计算并返回该式的最大值。
//
//
//
// 示例 1：
//
// 输入：nums = [3,4,5,2]
//输出：12
//解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) =
// 3*4 = 12 。
//
//
// 示例 2：
//
// 输入：nums = [1,5,4,5]
//输出：16
//解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
//
//
// 示例 3：
//
// 输入：nums = [3,7]
//输出：12
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 500
// 1 <= nums[i] <= 10^3
//
//
// Related Topics 数组 排序 堆（优先队列） 👍 69 👎 0


package leetcode.editor.cn;

/**
 * 数组中两元素的最大乘积
 * @author dukz
 * @date 2022-08-26 15:25:04
 */
public class P1464_MaximumProductOfTwoElementsInAnArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1464_MaximumProductOfTwoElementsInAnArray().new Solution();
	 }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
		int size = nums.length;
		if (size < 2){
			return -1;
		}
		int max1=nums[0],max2=nums[1];
		if(max2>max1){
			int temp = max1;
			max1=max2;
			max2=temp;
		}
		for (int i = 2; i < size; i++) {
			if(nums[i] > max1){
				max2 = max1;
				max1 = nums[i];
			}else if(nums[i] > max2){
				max2 = nums[i];
			}
		}
		return (max1-1)*(max2-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
