package leetcodestudy;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeAncestor {
    //剑指offer68
    public static void main(String[] args) {

    }
    //测试数据 root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    //分别计算根节点到两个节点的先序序列。然后比较最短的一个序列的最后一个节点
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> plist = new ArrayList<>();
        ArrayList<TreeNode> qlist = new ArrayList<>();
        getPreOrder(root,p,plist);
        getPreOrder(root,q,qlist);
        int n = Math.min(plist.size(),qlist.size());
        TreeNode res = null;
        for(int i=0;i<n;i++){
            if (plist.get(i) == qlist.get(i))
                return res = plist.get(i);
        }
        return res;

    }
    //先序遍历序列
    public static void getPreOrder(TreeNode root, TreeNode node, List<TreeNode> path){
        if(root==null)
            return ;
        path.add(root);
        if(root == node)
            return ;
        if(path.get(path.size()-1)!=node){
            getPreOrder(root.left,node,path);
        }
        if(path.get(path.size()-1)!=node){
            getPreOrder(root.right,node,path);
        }
        if(path.get(path.size()-1)!=node){
            path.remove(path.size()-1);
        }
    }
}
