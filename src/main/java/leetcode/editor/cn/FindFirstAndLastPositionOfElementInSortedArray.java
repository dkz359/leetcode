package leetcode.editor.cn;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1342 👎 0

import leetcode.editor.util.GyUtils;

public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] res = solution.searchRange(nums, target);
        GyUtils.printIntArr(res);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target);
        if(left == -1){
            return new int[]{-1, -1};
        }
        int right = searchRight(nums, target);
        return new int[]{left, right};
    }

    private int searchLeft(int[] nums, int target) {
        int low = 0,high = nums.length-1;
        while (low <= high){
            int mid = low + ((high-low)>>1);
            if(nums[mid] > target){
                high = mid - 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                if(mid ==0 || nums[mid-1]<target){
                    return mid;
                }else{
                    high = mid -1;
                }
            }

        }
        return -1;
    }

    private int searchRight(int[] nums, int target) {
        int n = nums.length;
        int low = 0,high = n -1;
        while (low <= high){
            int mid = low + ((high-low)>>1);
            if(nums[mid] > target){
                high = mid - 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                if(mid ==n-1 || nums[mid+1]>target){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}