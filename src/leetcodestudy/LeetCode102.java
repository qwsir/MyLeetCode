package leetcodestudy;

import java.util.*;

public class LeetCode102 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int count = queue.size();
            while(count-->0){
                TreeNode node = queue.poll();
                if (node == null){
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
