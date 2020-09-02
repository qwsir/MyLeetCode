package leetcodestudy;

import java.util.Scanner;

public class LeetCode61 {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        ListNode newhead = rotateRight(head, 2);

        while(newhead!=null){
            System.out.print(newhead.val+"\t");
            newhead=newhead.next;
        }
    }

    // 将链表结成环 然后判断应该断环的位置 得到新的链表
    public static ListNode rotateRight(ListNode head, int k){
            if(head==null||k==0){
                return head;
            }
            ListNode cursor=head;
            ListNode tail=null;//尾指针
            int length=1;
            while(cursor.next!=null)//循环 得到总长度
            {
                cursor=cursor.next;
                length++;
            }
            int loop=length-(k%length);//得到循环的次数
            tail=cursor;//指向尾结点
            cursor.next=head;//改成循环链表
            cursor=head;//指向头结点
            for(int i=0;i<loop;i++){//开始循环
                cursor=cursor.next;
                tail=tail.next;
            }
            tail.next=null;//改成单链表
            return cursor;//返回当前头
        }


}
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x)
        { val = x; }
        ListNode()
        { }
}
