package leetcodestudy;

import java.util.ArrayList;
import java.util.Stack;

public class LeetCode54 {
    public static void main(String[] args) {

    }
    //求二叉搜索数第k大的节点
    //二叉搜索的的中序遍历遍历就是一个有序的序列
    public int kthLargest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            root = node.right;
        }
        return list.get(list.size()-k);
    }

}
