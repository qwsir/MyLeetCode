package leetcodestudy;

import java.util.ArrayList;
import java.util.Collections;

public class LeetCodePool {
    public static void main(String[] args) {
        int[][] land = {
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}
        };
        int[] size = pondSizes(land);
        for(int num :size)
            System.out.println(num+"\t");
    }
    //leetcode 面试题 16.19水域大小
    public static int[] pondSizes(int[][] land) {
        ArrayList<Integer> list = new ArrayList<>();
        int row = land.length;
        int col = land[0].length;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(land[i][j]==0){
                    //进行深度优先搜索，并返回水域的大小
                    int river = dfsPool(land,i,j);
//                    System.out.println("i= "+i+"\tj= "+j+"\triver= "+river);
                    list.add(river);

                    //查看当前数组元素
//                    for(int x = 0;x < row;x++) {
//                    for (int y = 0; y < col; y++) {
//                        System.out.print(land[x][y] + "\t");
//                    }
//                    System.out.println();
//                }
            }
            }
        }
        Collections.sort(list);  //将list中的元素排序
        //将list转为数组
        int[] array = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            array[i] = list.get(i);
        }
        return array;
    }
    public static int dfsPool(int[][] land,int i,int j){
        int size =0;
        int row = land.length;
        int col = land[0].length;
        if(i<0||i>=row||j<0||j>=col||land[i][j]!=0)
            return size;
//        else {

            land[i][j] = -1;size++;
//        }
        //主要分为8个方向
        size+=dfsPool(land,i++,j);
        size+=dfsPool(land,i,j++);
        size+=dfsPool(land,i--,j);
        size+=dfsPool(land,i,j--);
        size+=dfsPool(land,i++,j++);
        size+=dfsPool(land,i--,j--);
        size+=dfsPool(land,i++,j--);
        size+=dfsPool(land,i--,j++);
        return size;
    }
}
