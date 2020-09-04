package leetcodestudy;

import com.sun.deploy.panel.ITreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class LeetCode105 {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode head = buildTree(preorder, inorder);
        //输出后序遍历
        List<Integer> list = postOrder(head);
        for (int temp : list)
            System.out.print(temp + "\t");
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //存储中序节点元素及其索引，方便后序查找
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(map, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode build(HashMap<Integer, Integer> map, int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pr < pl || ir < il) {
            return null;
        }
        //首先构造下一个根节点
        TreeNode root = new TreeNode(preorder[pl]);
        //定位根节点在中序中的位置
        int index = map.get(preorder[pl]);
        int leftcount = index - il;
        root.left = build(map, preorder, pl + 1, pl + leftcount, inorder, il, index - 1);
        root.right = build(map, preorder, pl + leftcount + 1, pr, inorder, index + 1, ir);
        return root;
    }

    public static List<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode head = s1.pop();
            s2.push(head);
            if (head.left != null) {
                s1.push(head.left);
            }
            if (head.right != null) {
                s1.push(head.right);
            }
        }
        while (!s2.isEmpty()) {
            list.add(s2.pop().val);
        }
        return list;
    }

}



/**
 * Definition for a binary tree node.
 * */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}