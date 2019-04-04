package linked.linked_0404;

public class TestLinked {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
83. 删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
示例 1:
输入: 1->1->2
输出: 1->2
示例 2:
输入: 1->1->2->3->3
输出: 1->2->3
 */
/*
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while(tmp != null){
            ListNode cur = tmp;
            while(cur.next != null){
                if(cur.next.val == tmp.val){
                    cur.next = cur.next.next;
                }else{
                    cur = cur.next;
                }
            }
            tmp = tmp.next;
        }
        return head;
    }
}*/
/*
234. 回文链表
请判断一个链表是否为回文链表。
示例 1:
输入: 1->2
输出: false
示例 2:
输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
//方法一
/*
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        while(fastNode != null && fastNode.next != null){
            stack.push(slowNode);
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        if(fastNode != null){
            slowNode = slowNode.next;
        }
        while(slowNode != null && !stack.empty()){
            if(slowNode.val != stack.peek().val){
                return false;
            }
            slowNode = slowNode.next;
            stack.pop();
        }
        return true;
    }
}*/
//方法二
/*
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        int length = getLength(head);
        int len = length/2;
        ListNode head1 = head;
        ListNode cur = head;
        for(int i=1; i<len; i++){
            ListNode tmp = cur.next;
            cur.next = cur.next.next;
            tmp.next = head1;
            head1 = tmp;
        }
        ListNode head2 = cur.next;
        if(length % 2 != 0){
            head2 = head2.next;
        }
        while(head1!=null && head2!=null){
            if(head1.val != head2.val){
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
    private int getLength(ListNode head){
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
}*/

/*
编写一个程序，找到两个单链表相交的起始节点。
注意：
如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
/*
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != curB){
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}*/
