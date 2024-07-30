package leetcode;

public class K个一组翻转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode listNode = reverseKGroup3(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k==1)return head;
        ListNode cur = head;
        while (true){
            ListNode pre = cur;
            ListNode after = cur;
            boolean flag = false;
            for (int i = 0; i < k; i++) {
                if(after.next!=null)after = after.next;
                else flag = true;
            }
            if(flag)break;
            cur = after;
            ListNode trace = pre.next.next;
            ListNode record1=pre.next;
            ListNode record2=pre;
           for (int i = 0; i < k-1; i++) {
                ListNode temp = trace.next;
                trace.next=pre.next;
                trace=temp;
                pre=pre.next;
            }
            record2.next=after;
            record1.next=after.next;
        }
        return head;
    }

    public static ListNode reverseKGroup2(ListNode head, int k) {
        if (k == 1 || head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while (true) {
            ListNode pre = cur;
            ListNode end = cur;

            // Check if there are k nodes left
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) return dummy.next;
            }

            ListNode nextGroup = end.next;
            // Disconnect the k-group from the rest of the list
            end.next = null;

            // Reverse the k-group
            ListNode start = pre.next;
            pre.next = reverse(start);

            // Connect the reversed k-group to the next part
            start.next = nextGroup;

            // Move cur to the end of the reversed k-group
            cur = start;
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }


    //自己写一遍
    public static ListNode reverseKGroup3(ListNode head, int k) {
        if(head==null||k==1)return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        while (true){
            ListNode pre=cur;
            ListNode end=cur;
            for (int i = 0; i < k; i++) {
                end=end.next;
                if(end==null)return dummy.next;
            }
            ListNode nextGroup = end.next;
            end.next=null;
            ListNode start = pre.next;
            pre.next=reverse2(start);
            start.next = nextGroup;
            cur = start;
        }
    }

    private static ListNode reverse2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

/*
给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。



示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
示例 2：



输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]*/
