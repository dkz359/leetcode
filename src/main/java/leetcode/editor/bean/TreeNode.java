package leetcode.editor.bean;

import leetcode.editor.cn.ConstructBinaryTreeFromPreorderAndInorderTraversal;

/**
 * 树结构
 *
 * @author dukezheng
 * @ClassName TreeNode
 * @date 2022/1/21 15:51
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode() {}
	public TreeNode(int val) { this.val = val; }
	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

}