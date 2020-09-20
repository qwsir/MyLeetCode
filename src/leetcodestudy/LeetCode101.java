package leetcodestudy;

public class LeetCode101 {
    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return judgeSymmetric(root.left,root.right);
    }
    public boolean judgeSymmetric(TreeNode left,TreeNode right){
        if(left==null||right==null)
            return left == right;
        return left.val == right.val&& judgeSymmetric(left.left,right.right)&&judgeSymmetric(left.right,right.left);
    }
}
