//给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
//
//
// 示例 2：
//
//
//输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：19
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [1, 10⁴] 之间。
// 1 <= Node.val <= 100
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 121 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 层数最深叶子节点的和
 *
 * @author dukz
 * @date 2022-08-17 14:37:44
 */
public class P1302_DeepestLeavesSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1302_DeepestLeavesSum().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int maxLevel = -1;
        int sum = 0;

        public int deepestLeavesSum(TreeNode root) {
            //dfs(root, 0);
			sum = bfs(root);
            return sum;
        }

		/**
		 * 深度优先
		 * @param node
		 * @param level
		 */
        public void dfs(TreeNode node, int level) {
            if (node == null) {
                return;
            }
            if (level > maxLevel) {
                maxLevel = level;
                sum = node.val;
            } else if (level == maxLevel) {
                sum += node.val;
            }
            dfs(node.left, level + 1);
            dfs(node.right, level + 1);
        }

		/**
		 * 广度优先
		 * @param root
		 */
		public int bfs(TreeNode root){
			Queue<TreeNode> queue = new ArrayDeque<>();
			queue.offer(root);
			int sum = 0;
			while (!queue.isEmpty()){
				sum = 0;
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					sum += node.val;
					if(node.left != null){
						queue.offer(node.left);
					}
					if(node.right != null){
						queue.offer(node.right);
					}
				}
			}
			return sum;
		}
    }
//leetcode submit region end(Prohibit modification and deletion)

}
