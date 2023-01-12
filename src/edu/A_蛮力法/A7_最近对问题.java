package edu.A_蛮力法;

/**
 * @Author WesterlyWindWuTong
 * @Date 2023/1/11 00:25
 * @Version 1.0
 * @Description:
 */
public class A7_最近对问题 {
    public static void main(String[] args) {
        int[] x = {1, 3, 5, 1};
        int[] y = {1, 2, 4, 2};
        ClosestPoints(x, y, 4);
    }

    private static void ClosestPoints(int[] x, int[] y, int n) {
        int index1 = 0, index2 = 0;                           //记载最近点对的下标
        int d, minDist = 1000;                        //假设最大距离不超过1000
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)                  //只考虑i＜j的点对
            {
                d = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
                if (d < minDist) {
                    minDist = d;
                    index1 = i;
                    index2 = j;
                }
            }
        System.out.println("最近的点对是：" + index1 + "和" + index2);
    }
}
