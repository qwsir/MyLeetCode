package leetcodestudy;

public class LeetCode904 {
    public static void main(String[] args) {
        int[] tree={3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(tree));;
    }
    public static int totalFruit(int[] tree){
        int first=0;  //first和fast分别指向两种不同水果的最初区间
        int last=0;
        int treeNum=0;
        int max=0;
        for(int i=0;i<tree.length;i++){
            if(tree[i]==tree[first]||tree[i]==tree[last]){  //处于区间之间
                treeNum++;
            }
            else {
                if (tree[first]==tree[last]){   //处于区间,且此时的tree[i]为第二种果树
                    last=i;
                    treeNum++;
                }
                else{          //跳出之前的区间,且此时的tree[i]为第三种果树
                    treeNum=1;
                    int index=i-1;
                    while(tree[i-1]==tree[index-1]){
                        treeNum++;
                        index--;
                    }
                    first=index;
                    last=i;
                    treeNum++;
                }
            }
            max=Math.max(max,treeNum);
        }
        return max;
    }
}
