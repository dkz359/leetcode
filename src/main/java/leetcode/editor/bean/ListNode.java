package leetcode.editor.bean;

/**
 * @author dukezheng
 * @ClassName ListNode
 * @Description 链表节点
 * @date 2021/5/14 18:25
 * @Version 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
