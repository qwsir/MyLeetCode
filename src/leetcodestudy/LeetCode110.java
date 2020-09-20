package leetcodestudy;

public class LeetCode110 {
    public static void main(String[] args) {

    }
    public boolean isBalanced(TreeNode root) {
        return root==null||isBalanced(root.left)&&isBalanced(root.right)&&(Math.abs(height(root.left)-height(root.right))<=1);
    }
    public int height(TreeNode root){
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
}
