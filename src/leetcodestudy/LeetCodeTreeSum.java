package leetcodestudy;

public class LeetCodeTreeSum {
    private int temp = 0;
    public static void main(String[] args) {

    }
    public  int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        //根节点递归
        dfs(root,sum);
        //根节点左节点递归
        pathSum(root.left,sum);
        //根节点右节点递归
        pathSum(root.right,sum);
        return temp;
    }
    public void dfs(TreeNode root,int sum){
        if(root == null)
            return ;
        sum-= root.val;
        if(sum == 0 )
            temp++;
        dfs(root.left,sum);
        dfs(root.right,sum);
    }
}
