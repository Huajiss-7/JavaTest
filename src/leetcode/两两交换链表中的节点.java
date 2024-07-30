package leetcode;

public class 两两交换链表中的节点 {
    public static void main(String[] args) {
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        head=swapPairs(head);
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode pre=null,cur=head,ans=head.next;
        while(cur!=null&&cur.next!=null){
            ListNode n1=cur,n2=cur.next;
            if(pre!=null){
                pre.next=n2;
            }
            n1.next=n2.next;
            n2.next=n1;
            pre=n1;
            cur=n1.next;
        }
        return ans;
    }
}

/*
给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。



        示例 1：


        输入：head = [1,2,3,4]
        输出：[2,1,4,3]
        示例 2：

        输入：head = []
        输出：[]
        示例 3：

        输入：head = [1]
        输出：[1]*/
