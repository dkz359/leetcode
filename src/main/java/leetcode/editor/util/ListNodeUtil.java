package leetcode.editor.util;

import leetcode.editor.bean.ListNode;

/**
 * @author dukezheng
 * @ClassName PrintListNode
 * @Description 打印listNode
 * @date 2021/7/14 18:04
 * @Version 1.0
 */
public class ListNodeUtil {

	public static void print(ListNode head){
		while (head != null){
			System.out.print(head.val + "  ");
			head = head.next;
		}
		System.out.println();
	}

}
