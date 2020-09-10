package leetcodestudy;

import java.util.Scanner;

public class LeetCode24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 4;
        ListNode head = new ListNode();
        ListNode temp ;
        //尾插法创建链表，节点个数为4
        while(count-->0){
            int value = in.nextInt();
            if(head==null){
                head = new ListNode(value);
            }
            temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new ListNode(value);
        }
        //链表两两翻转方法
        ListNode mynode = swapPairs(head.next);
        //输出链表
        while(mynode!=null){
            System.out.println(mynode.val);
            mynode = mynode.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        //root.next 用来存放链表的头结点
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode pre = root;
        while(pre.next!=null&&pre.next.next!=null){
            ListNode temp = pre.next.next;    //用来指向待翻转节点中的第二个
            pre.next.next = temp.next;
            temp.next = pre.next;             //两个节点交换位置
            pre.next = temp;
            pre = pre.next.next;              //移动指针，其中pre的next为待交换的第一个节点
        }
        return root.next;
    }
}

