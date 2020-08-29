package list;

import java.util.Stack;

public class Liang_ge_lian_biao_de_di_yi_ge_gong_gong_jie_dian_lcof_52 {
    //方法一：压栈法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }
        ListNode res = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek() == stackB.peek()) {
                res = stackA.pop();
                stackB.pop();
            } else
                break;
        }
        return res;
    }

    //方法二：求每个链表长度，长的多走“差值”步
    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lengthA = getLength(headA); //此部分有重复，所以抽象出来
        int lengthB = getLength(headB);

        if (lengthB - lengthA > 0) {
            ListNode tmp = headA;
            headA = headB;
            headB = tmp;
        }
        int diff = Math.abs(lengthA - lengthB); //注意如果交换了指针，那么可能是复数
        while (diff > 0) { //长的链表，先走 diff 步
            headA = headA.next;
            diff--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    //方法三：相遇法：自己的走完之后就走别人的
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        if (headA == null || headB ==null)
            return null;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA != null ? curA.next : headB;
            curB = curB != null ? curB.next : headA;
        }
        return curA;
    }
}
