package leetcodestudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class LeetCode106 {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};
        TreeNode head = buildTree(inorder, postOrder);
        ArrayList<Integer> list = preorder(head);
        for(int temp :list){
            System.out.print(temp+"\t");
        }
        ArrayList<Integer> list2 = inorder(head);
        for(int temp :list2){
            System.out.print(temp+"\t");
        }
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(map,inorder,0,inorder.length-1,postorder,0,postorder.length-1);

    }
    public static TreeNode build(HashMap<Integer,Integer> map,int[] inorder, int il,int ir,int[] postorder,int pl,int pr){
        if (il>ir||pl>pr)
            return null;
        TreeNode head = new TreeNode(postorder[pr]);
        int index = map.get(postorder[pr]);
        int leftcount = index-il;
        head.left = build(map,inorder,il,index-1,postorder,pl,pl+leftcount-1);
        head.right = build(map,inorder,index+1,ir,postorder,pl+leftcount,pr-1);
        return head;
    }
    public static ArrayList<Integer> preorder(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode head = s1.pop();
            list.add(head.val);
            if(head.right!=null){
                s1.add(head.right);
            }
            if(head.left!=null){
                s1.add(head.left);
            }
        }
        return list;
    }
    public static ArrayList<Integer> inorder(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        Stack<TreeNode> s1 = new Stack<>();
        while(root!=null||!s1.isEmpty()){
            while(root!=null){
                s1.push(root);
                root=root.left;
            }
            TreeNode top = s1.pop();
            list.add(top.val);
            root=top.right;
        }
        return list;
    }

}

