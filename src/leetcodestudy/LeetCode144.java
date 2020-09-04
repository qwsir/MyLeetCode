package leetcodestudy;

import java.util.ArrayList;
import java.util.Stack;

public class LeetCode144 {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> preorder(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode head = s1.pop();
            list.add(head.val);
            if(head.right!=null){
                s1.add(head.right);
            }
            if(head.left!=null){
                s1.add(head.left);
            }
        }
        return list;
    }
}
