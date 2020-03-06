package list;

import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoLinkedLists_160 {

    // 暴力法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode join = null;
        ListNode currA = headA;
        while (currA != null) {
            join = currA;
            ListNode currB = headB;
            while (currB != null) {
                //如果遇到相同的节点，返回该节点
                if (join == currB) {
                    return currA;
                } else { //没有相同的节点，则继续查找
                    currB = currB.next;
                }
            }
            currA = currA.next;
        }
        return currA;
    }
    //哈希表
    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        Map<Integer,ListNode> map = new HashMap<Integer, ListNode>();
        int count = 0;
        while (currA != null) {
            map.put(count++, currA);
            currA = currA.next;
        }

        while (currB != null) {
            if(map.containsValue(currB)){
                return currB;
            }
            currB = currB.next;
        }
        return currA;
    }

    // a+b = b+a 方法
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        //注意点1
        if(headA == null || headB == null){
            return null;
        }
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != currB) {
            //注意点2：得到下个节点的语句的位置
            currA = currA.next;
            currB = currB.next;
            //注意点3：防止无限循环，当没有交集时，相较于null;
            if(currA == null && currB == null){
                return null;
            }
            if(currA == null){
                currA = headB;
            }
            if(currB == null){
                currB = headA;
            }
        }
        return currA;
    }
}
