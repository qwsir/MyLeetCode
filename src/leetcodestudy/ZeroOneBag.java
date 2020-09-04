package leetcodestudy;

public class ZeroOneBag {
    public static void main(String[] args) {
        int[] weight = {0, 2, 3, 4, 5};
        int[] value = {0, 3, 4, 5, 6};

        int capacity = 8;
        int m = weight.length, n = capacity + 1;
        int[][] v = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //处理边界
                if (i == 0) {
                    v[i][j] = 0;
                } else if (j == 0) {
                    v[i][j] = 0;
                }// 处理非边界
                else {
                    if (j < weight[i]) {
                        v[i][j] = v[i - 1][j];
                    } else {
                        //v[i - 1][j - weight[i]] + value[i]表示如果需要装下第i个物体，
                        //则背包的容量需要回到第i-1个中，背包容量为j-weight[i]的状态，
                        //然后从这个状态假设加上第i个物品后，看总价值是否超过v[i - 1][j]
                        v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - weight[i]] + value[i]);
                    }
                }
            }
        }
        System.out.println("物品的最大价值为：" + v[m - 1][n - 1]);
        System.out.println("动态规划表如下：");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(v[i][j] + "\t");
            }
            System.out.println();

        }
    }
}
