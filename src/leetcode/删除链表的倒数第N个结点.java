package leetcode;

public class 删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        head=removeNthFromEnd(head,2);
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast=head;
        ListNode slow=dummy;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        while (fast!=null){//这时候fast到达链表尾的下一个节点，slow到达要删除节点的前一个节点
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;//头节点有可能被删，这时候返回null
    }
}

/*给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。



        示例 1：


        输入：head = [1,2,3,4,5], n = 2
        输出：[1,2,3,5]
        示例 2：

        输入：head = [1], n = 1
        输出：[]
        示例 3：

        输入：head = [1,2], n = 1
        输出：[1]*/
