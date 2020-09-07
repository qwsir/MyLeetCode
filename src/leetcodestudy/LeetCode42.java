package leetcodestudy;

public class LeetCode42 {
    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
    }

    public static int trap(int[] height) {
        //1. 分别找到 当前列左右两边的最大长度的列
        //2. 只有当这两列的值均大于当前列的高度才能存储水
        int sum=0;
        for(int i=1;i<height.length-1;i++){
            int left = i-1, right = i+1;
            int left_max=0, right_max=0;
            while(left>=0){
                if (height[left]>left_max)
                    left_max=height[left];
                left--;
            }
            while(right<height.length){
                if (height[right]>right_max)
                    right_max=height[right];
                right++;
            }
            //找出两端的最小值
            int min = Math.min(left_max,right_max);
            if(min>height[i]){
                sum+=(min-height[i]);
            }
        }
        return sum;
    }
    //下面的方法是预先已经计算了第i列左右两边的最大值(不包括当前的第i列)
//    public int trap(int[] height) {
//        int sum = 0;
//        int[] max_left = new int[height.length];
//        int[] max_right = new int[height.length];
//
//        for (int i = 1; i < height.length - 1; i++) {
//            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
//        }
//        for (int i = height.length - 2; i >= 0; i--) {
//            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
//        }
//        for (int i = 1; i < height.length - 1; i++) {
//            int min = Math.min(max_left[i], max_right[i]);
//            if (min > height[i]) {
//                sum = sum + (min - height[i]);
//            }
//        }
//        return sum;
//    }

}
