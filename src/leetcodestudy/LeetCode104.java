package leetcodestudy;

public class LeetCode104 {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = maxDepth(root.left)+1;
        int right = maxDepth(root.right)+1;
        return Math.max(left,right);
    }
}
