package leetcodestudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode145 {

    public static void main(String[] args) {
        //构造二叉树序列   //1 null 2 3
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);
        List<Integer> list = postorderTraversal(node1);
        for(Integer temp:list)
            System.out.print(temp+"\t");
    }

    /**
     *1 构造两个栈s1和s2,
     *2 将头结点压入s1，s1将节点压入s2中，并将此节点的左右子树分别压入s1
     *3 重复2中操作，直到s1栈空为止，栈s2中元素出栈即为后序遍历
     ********  因为s1中元素入栈为中--->(左--->右)，所以出栈到s2的顺序为中--->(右--->左)
     ********  s2中元素出栈顺序即为 左 右 中
     *****     递归方式见解法二
     */
    public static List<Integer> postorderTraversal(TreeNode node) {
        ArrayList<Integer> list = new ArrayList<>();
        if(node==null)
            return list;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(node);
        while(!s1.isEmpty()){
            TreeNode root=s1.pop();
            s2.push(root);
            if(root.left!=null){
                s1.push(root.left);
            }
            if(root.right!=null){
                s1.push(root.right);
            }
        }
        while(!s2.isEmpty()){
            list.add(s2.pop().val);
        }
        return list;
    }
    // 递归方式后序遍历
//    public static List<Integer> postorderTraversal(TreeNode root) {
//        ArrayList<Integer> res=new ArrayList<>();
//        if(root==null)
//            return res;
//        res.addAll(postorderTraversal(root.left));
//        res.addAll(postorderTraversal(root.right));
//        res.add(root.val);
//        return res;
//    }
}
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
