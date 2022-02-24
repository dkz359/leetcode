package leetcode.editor.cn;

//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列
// 前序遍历结果：[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
// 中序遍历结果：[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1385 👎 0

import leetcode.editor.bean.TreeNode;
import leetcode.editor.util.TreeNodeUtil;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] preorder = {3,9,12,20,15,7}, inorder = {12,9,3,15,20,7};
        TreeNode tree = solution.buildTree(preorder, inorder);
        TreeNodeUtil.show(tree);
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeItem(preorder,0,n-1,inorder,0,n-1);
    }
    public TreeNode buildTreeItem(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if(preLeft>preRight){
            return null;
        }
        int root = preorder[preLeft];
        TreeNode treeNode = new TreeNode(root);
        // int rootInorder = findIndex(inorder, root);
        int rootInorder = indexMap.get(root);
        int leftSize = rootInorder - inLeft;
        treeNode.left = buildTreeItem(preorder, preLeft+1, preLeft+leftSize, inorder, inLeft, rootInorder-1);
        treeNode.right = buildTreeItem(preorder, preLeft+leftSize+1, preRight, inorder, rootInorder+1, inRight);
        return treeNode;
    }

    /**
     * 此方法太慢了，可以采用hashmap优化
     * @param inorder
     * @param data
     * @return
     */
    @Deprecated
    public int findIndex(int[] inorder, int data){
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == data){
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}