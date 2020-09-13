package leetcodestudy;

public class LeetCodeTree {
    private boolean flag = true;
    public static void main(String[] args) {
        int[] tree = {1,2,2,3,3,0,0,4,4};
    }
    public  boolean isBalanced(TreeNode root){
        dfsHeight(root);
        return flag;
    }
    public int dfsHeight(TreeNode root){
        if(root == null || !flag){
            return 0;
        }
        int left = dfsHeight(root.left);
        int right = dfsHeight(root.right);
        if(Math.abs(left - right) > 1){
            flag = true;
        }
        return 1 + Math.max(left,right);
    }
}
