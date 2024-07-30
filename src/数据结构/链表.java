package 数据结构;

// 节点类
class Node {
    int data;
    Node next;

    // 构造函数
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// 链表类
class LinkedList {
    Node head;

    // 构造函数
    public LinkedList() {
        this.head = null;
    }

    // 在链表末尾添加一个节点
    public void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }

    // 在链表头部插入一个节点
    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 打印链表的所有节点值
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class 链表 {
    public static void main(String[] args) {
        // 创建链表
        LinkedList linkedList = new LinkedList();

        // 在链表末尾添加节点
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        // 在链表头部插入节点
        linkedList.prepend(0);

        // 打印链表
        linkedList.printList();
    }
}

