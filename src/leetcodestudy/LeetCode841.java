package leetcodestudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode841 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,3);
        List<Integer> list2 = Arrays.asList(3,0,1);
        List<Integer> list3 = Arrays.asList(2);
        List<Integer> list4 = Arrays.asList(0);
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(list1);rooms.add(list2);
        rooms.add(list3);rooms.add(list4);
        System.out.println(canVisitAllRooms(rooms));
    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        boolean[] room = new boolean[size];   //用来判断是否有房间被访问过
        room[0] = true;                       //其中房间0可以访问
        Stack<Integer> keys = new Stack<>();  //用来存储每个房间的钥匙，
        keys.push(0);                   //最开始有0号房间的钥匙
        while(!keys.isEmpty()){
            Integer roomnum = keys.pop();    //获取该钥匙可以开的房间号
            room[roomnum] =true;             //将该钥匙可以开的房间置为可访问
            for(int key : rooms.get(roomnum)){ //获取该房间的所有钥匙
               if(!room[key]){                //如果该钥匙对应的房间没有被访问过将钥匙压入栈中
                   keys.push(key);
               }
            }

        }
        for(boolean flag : room){
            if (flag == false)
                return false;
        }
        return true;
    }
}
