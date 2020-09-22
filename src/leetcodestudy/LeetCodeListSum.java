package leetcodestudy;

public class LeetCodeListSum {
    public static void main(String[] args) {

    }
    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int index = 0;
        int num = 0;
        ListNode res = new ListNode(0);
        ListNode cur = res;       //记录每次产生的新节点
        while(l1 != null || l2 != null){    //各个位数相加并记录产生的进位
            int num1 = l1!=null? l1.val : 0;
            int num2 = l2!=null? l2.val : 0;
            int sum = num1 + num2 + index;
            index = sum/10;  //记录产生的进位
            num = sum%10;   //记录每次进位之后的数字
            cur.next = new ListNode(num);
            cur = cur.next;      //要求数字的顺序与链表中数字的顺序相反，应使用尾插法
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
        }
        if(index == 1){   //最后产生了一次进位
            cur.next = new ListNode(1);
        }
        return res.next;
    }
}
