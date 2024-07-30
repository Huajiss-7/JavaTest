package leetcode;

import java.util.HashSet;
import java.util.Set;

public class 环形链表 {
    public static void main(String[] args) {
        ListNode list=new ListNode(3);
        list.next=new ListNode(2);
        list.next.next=new ListNode(0);
        list.next.next.next=new ListNode(-4);
        list.next.next.next.next=list.next;//尾节点指向第二个节点

        System.out.println(hasCycle(list));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode quick=head;
        if(head==null||head.next==null)return false;
        while (true){
            if(slow==null||quick==null||quick.next==null)return false;//如果quick正好到链表尾部，再quick.next会空指针
            slow=slow.next;
            quick=quick.next.next;
            if(slow==quick)return true;
        }
    }

    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {//如果加入已经存在的元素，就添加失败返回false，存储的是链表节点，不是节点的val所以不担心值重复
                return true;
            }
            head = head.next;
        }
        return false;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

    /*给你一个链表的头节点 head ，判断链表中是否有环。

        如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。

        如果链表中存在环 ，则返回 true 。 否则，返回 false 。*/