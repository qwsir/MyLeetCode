package leetcodestudy;

import java.util.ArrayList;
import java.util.Stack;

public class LeetCodeSearchTree {
    public static void main(String[] args) {

    }
    //思路1：二叉搜索树的中序遍历为递增序列
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            int val = node.val;
            list.add(val);
            root = node.right;
        }
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>=list.get(i+1)){
                return false;
            }
        }
        return true;
    }
}
