package leetcodestudy;

import java.util.ArrayList;
import java.util.Stack;

public class LeetCode94 {
    public static void main(String[] args) {

    }
    public static ArrayList<Integer> inorder(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        Stack<TreeNode> s1 = new Stack<>();
        while(root!=null||!s1.isEmpty()){
            while(root!=null){
                s1.push(root);
                root=root.left;
            }
            TreeNode top = s1.pop();
            list.add(top.val);
            root=top.right;
        }
        return list;
    }

}
